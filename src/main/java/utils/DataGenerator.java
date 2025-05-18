package utils;

import net.datafaker.Faker;

import java.util.Random;
import java.util.UUID;

public class DataGenerator
{
    private static final Random random = new Random();

    public static String generateRandomEmail() {
        return "user" + random.nextInt(100000) + "@testmail.com";
    }

    public static String generateUSPhoneNumber() {


        String s ="+1815697";

            Random r = new Random();
            int i = r.nextInt(9999);
            if(i <= 1000) {
                i = i + 1000;
            }

            s= s + i;

        System.out.println("Mobile number generated is --->" + s);
            return s;


    }

    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }

    public static String generateRandomName() {
        return "TestUser" + random.nextInt(10000);
    }

    public static String randomDeviceId()

    {

        Random random=new Random();
        int number=random.nextInt(100);
        String email="vikas"+number+"91"+number+"@gmail.com";
        return email;

    }

    public static Faker faker = new Faker();

    public static String getRamdomDataFor(RandomGeneratorTypes rt)
    {
        switch (rt)
        {
            case FirstName:
                return faker.name().firstName();
            case LastName:
                return faker.name().lastName();
            case Country:
                return faker.address().country();
            case CityName:
                return faker.address().city();
            default:
                return "data type not available for input";

        }

    }
}
