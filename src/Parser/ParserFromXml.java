package Parser;

import CheckCorrectData.CheckCorrectInput;
import CheckCorrectData.CheckPathCorrect;
import Data.Car;
import Data.Coordinates;
import Data.HumanBeing;
import Data.WeaponType;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.LinkedList;

import static java.lang.System.exit;

/**
 * ParseFromXml class
 */
public class ParserFromXml {
    private static final String TAG_NAME = "name";
    private static final String TAG_COORDINATE_X = "coordinate_x";
    private static final String TAG_COORDINATE_Y = "coordinate_y";
    private static final String TAG_REAL_HERO = "real_hero";
    private static final String TAG_HAS_TOOTHPICK = "has_toothpick";
    private static final String TAG_IMPACT_SPEED = "impact_speed";
    private static final String TAG_SOUNDTRACK_NAME = "soundtrack_name";
    private static final String TAG_MINUTES_OF_WAITING = "minutes_of_waiting";
    private static final String TAG_WEAPON_TYPE = "weapon_type";
    private static final String TAG_CAR = "car";
    private static final String TAG_ELEMENT = "element";

    private CheckPathCorrect checkPathCorrect = new CheckPathCorrect();
    LinkedList<HumanBeing> collectionList = new LinkedList<>();
    private Long id = 1L;

    private String name = null, car = "", soundtrack = "", weaponType = null;
    private Float x = Float.valueOf(1000000), y = Float.valueOf(1000000);
    private Boolean realHero = null, hasToothpick = null;
    private Long impactSpeed = null;
    private Integer minutesOfWaiting = null;

    /**
     *
     * @return converting from XML collection
     */
    public LinkedList getCollection() {
        return collectionList;
    }
    public Long getLastIdFromFile() {
        return id;
    }

    /**
     * Check that input file is correct
     * @return is file correct
     */
    public boolean check () {
        CheckCorrectInput checkCorrectInput = new CheckCorrectInput();

        int isCorrectInput = 1;
        isCorrectInput *= checkCorrectInput.checkName(name);
        isCorrectInput *= checkCorrectInput.checkCoordinateX(x);
        isCorrectInput *= checkCorrectInput.checkCoordinateY(y);
        isCorrectInput *= checkCorrectInput.checkRealHero(realHero);
        isCorrectInput *= checkCorrectInput.checkSoundtrackName(soundtrack);
        isCorrectInput *= checkCorrectInput.checkWeaponTypeFile(weaponType);
        isCorrectInput *= checkCorrectInput.checkCar(car);

        return isCorrectInput == 1;
    }

    /**
     * Add an element to collection
     */
    public void addToCollection() {
        HumanBeing element = new HumanBeing(id, name, new Coordinates(x, y), realHero, hasToothpick, impactSpeed,
                soundtrack, minutesOfWaiting, WeaponType.valueOf(weaponType.trim()), new Car(car));

        collectionList.add(element);
    }

    /**
     * Parse data from XML
     */
    public void parser(String args[]) {
        String value = System.getenv("FILEPATH");
        String argv[] = new String[1];
        argv[0] = value;

        if(!checkPathCorrect.checkPath(argv)) {
            exit(0);
        }

        File file = new File(argv[0].trim());

        if (file.length() == 0) {
            System.out.println("Вы подали на вход пустой файл. Все функции программы работают в прежнем режиме.");
            return;
        }

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document doc = null;

        try {
            doc = dbf.newDocumentBuilder().parse(file);
        }
        catch (IOException e) {
            System.out.println("Нет доступа к файлу. Проверьте разрешения на этот файл");
            exit(1);
        } catch (ParserConfigurationException | SAXException e) {
            System.out.println("Ошибка обработки файла. Попробуйте еще раз.");
            exit(1);
        }

        NodeList collection = doc.getElementsByTagName(TAG_ELEMENT);
        for (int i  = 0; i < collection.getLength(); i++) {
            if (collection.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            NodeList collectionChildren = collection.item(i).getChildNodes();
            for (int j = 0; j < collectionChildren.getLength(); j++) {
                if (collectionChildren.item(j).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }

                switch(collectionChildren.item(j).getNodeName()) {
                    case TAG_NAME :
                        name = collectionChildren.item(j).getTextContent();
                        break;

                    case TAG_COORDINATE_X :
                        x = Float.parseFloat(collectionChildren.item(j).getTextContent());
                        break;

                    case TAG_COORDINATE_Y :
                        y = Float.parseFloat(collectionChildren.item(j).getTextContent());
                        break;

                    case TAG_REAL_HERO :
                        realHero = Boolean.parseBoolean(collectionChildren.item(j).getTextContent());
                        break;

                    case TAG_HAS_TOOTHPICK :
                        hasToothpick = Boolean.parseBoolean(collectionChildren.item(j).getTextContent());
                        break;

                    case TAG_IMPACT_SPEED :
                        impactSpeed = Long.parseLong(collectionChildren.item(j).getTextContent());
                        break;

                    case TAG_SOUNDTRACK_NAME :
                        soundtrack = collectionChildren.item(j).getTextContent();
                        break;

                    case TAG_MINUTES_OF_WAITING:
                        minutesOfWaiting = Integer.parseInt(collectionChildren.item(j).getTextContent());
                        break;

                    case TAG_WEAPON_TYPE :
                        weaponType = collectionChildren.item(j).getTextContent();
                        break;

                    case TAG_CAR :
                        car = collectionChildren.item(j).getTextContent();
                        break;
                }
            }

            if (check()) {
                addToCollection();
                id++;
            } else {
                System.out.println("Элемент с № " + id + " не может быть добавлен из - за некорректных данных");
            }
        }
    }
}