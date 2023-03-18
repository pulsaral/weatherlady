package org.example;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class WeatherMenu {
    static SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    static Session session = sessionFactory.openSession();
    static Transaction transaction = session.getTransaction();

    public static void main(String[] args) {
    	WeatherApi api = new WeatherApi();
    	api.getWeather("Tirana");
    	
    	
//        callMenu();
    }
    
    public static void callMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------");
        System.out.println("1. Add City");
        System.out.println("2. List Cities");
        System.out.println("3. Get Weather");
        System.out.println("4. Delete a City ");
        System.out.println("0. Exit");
        System.out.println("--------------------------");
        System.out.println("Choose an option from menu: ");
        int onMenu = sc.nextInt();

        switch (onMenu)
        {
            case 0:
                System.exit(0);
                break;
            case 1:
                try {
                    transaction.begin();
                    sc.nextLine();
                    System.out.println("Country: ");
                    String country = sc.nextLine();
                    if (country.isEmpty())
                    {
                        System.out.println("Country can not be empty! ");
                        break;
                    }
                    System.out.println("City: ");
                    String city = sc.nextLine();
                    if (city.isEmpty())
                    {
                        System.out.println("City can not be empty! ");
                        break;
                    }
                    Cities cities = new Cities(country,city);
                    session.persist(cities);
                    transaction.commit();
                    System.out.println("City successfully added");
                    callMenu();
                }
                catch (Exception e){e.printStackTrace();
                }
                break;
            case 2:
                try {
                    transaction.begin();
                    List<Cities> allCities = session.createQuery("From Cities").list();
                    System.out.println("All Cities");
                    System.out.println("=============================");
                    System.out.printf( "%-5s%-15s%-15s\n", "ID", "Country","City");
                    System.out.println("=============================");
                    for(Cities element : allCities)
                    {
                        System.out.printf( "%-5s%-15s%-15s\n", element.getId(), element.getCountry(),element.getCity());
                    }
                    System.out.println("=============================");

                    transaction.commit();

                    callMenu();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 3:

                //  Get Weather

                break;
            case 4:

               // Delete a City

                break;
            default:
                System.out.println("Invalid option");
                callMenu();
                break;
        }
    }
}
