package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
public class Main {

    public static ArrayList<City> buidCity(){
        ArrayList<City> cities=new  ArrayList<City>();

        City city1=new City(4,7);
        city1.father=new City(city1.r,city1.c);
        city1.city[0][0].cellType=CellType.Street;
        city1.city[0][1].cellType=CellType.Street;
        city1.city[0][2].cellType=CellType.Street;
        city1.city[0][3].cellType=CellType.Street;
        city1.city[0][4].cellType=CellType.Street;
        city1.city[0][5].cellType=CellType.Bilding;
        city1.city[0][6].cellType=CellType.Street;
        city1.xStart=0;city1.x=0;city1.yStart=6;city1.y=6;


        city1.city[1][0].cellType=CellType.Street;
        city1.city[1][1].cellType=CellType.P;city1.city[1][1].index=0;
        city1.city[1][2].cellType=CellType.Bilding;
        city1.city[1][3].cellType=CellType.Bilding;
        city1.city[1][4].cellType=CellType.Street;
        city1.city[1][5].cellType=CellType.Bilding;
        city1.city[1][6].cellType=CellType.Street;


        city1.city[2][0].cellType=CellType.D; city1.city[2][0].index=0;
        city1.city[2][1].cellType=CellType.Street;
        city1.city[2][2].cellType=CellType.Street;
        city1.city[2][3].cellType=CellType.Bilding;
        city1.city[2][4].cellType=CellType.Street;
        city1.city[2][5].cellType=CellType.Street;
        city1.city[2][6].cellType=CellType.Street;

        city1.city[3][0].cellType=CellType.Street;
        city1.city[3][1].cellType=CellType.Street;
        city1.city[3][2].cellType=CellType.Street;
        city1.city[3][3].cellType=CellType.Bilding;
        city1.city[3][4].cellType=CellType.Street;
        city1.city[3][5].cellType=CellType.Street;
        city1.city[3][6].cellType=CellType.Street;

        city1.calcNumPacksge();
        cities.add(city1);

        City city2=new City(4,7);
        city2.father=new City(city1.r,city1.c);
        city2.city[0][0].cellType=CellType.Street;
        city2.city[0][1].cellType=CellType.Street;
        city2.city[0][2].cellType=CellType.Street;
        city2.city[0][3].cellType=CellType.Street;
        city2.city[0][4].cellType=CellType.Street;
        city2.city[0][5].cellType=CellType.Bilding;
        city2.city[0][6].cellType=CellType.Street;
        city2.xStart=0;city2.x=0;city2.yStart=6;city2.y=6;


        city2.city[1][0].cellType=CellType.Street;
        city2.city[1][1].cellType=CellType.Street;
        city2.city[1][2].cellType=CellType.Bilding;
        city2.city[1][3].cellType=CellType.Bilding;
        city2.city[1][4].cellType=CellType.Street;
        city2.city[1][5].cellType=CellType.Bilding;
        city2.city[1][6].cellType=CellType.Street;


        city2.city[2][0].cellType=CellType.Street;
        city2.city[2][1].cellType=CellType.Street;
        city2.city[2][2].cellType=CellType.P;city2.city[2][2].index=0;
        city2.city[2][3].cellType=CellType.Bilding;
        city2.city[2][4].cellType=CellType.Street;
        city2.city[2][5].cellType=CellType.Street;
        city2.city[2][6].cellType=CellType.Street;

        city2.city[3][0].cellType=CellType.Street;
        city2.city[3][1].cellType=CellType.Street;
        city2.city[3][2].cellType=CellType.Street;
        city2.city[3][3].cellType=CellType.Street;
        city2.city[3][4].cellType=CellType.Street;
        city2.city[3][5].cellType=CellType.Bilding;
        city2.city[3][6].cellType=CellType.D; city2.city[3][6].index=0;

        city2.calcNumPacksge();
        cities.add(city2);

        City city3=new City(4,7);
        city3.father=new City(city1.r,city1.c);
        city3.city[0][0].cellType=CellType.Street;
        city3.city[0][1].cellType=CellType.Street;
        city3.city[0][2].cellType=CellType.Bilding;
        city3.city[0][3].cellType=CellType.Street; city3.xStart=0;city3.x=0;city3.yStart=3;city3.y=3;
        city3.city[0][4].cellType=CellType.Bilding;
        city3.city[0][5].cellType=CellType.Street;
        city3.city[0][6].cellType=CellType.Street;



        city3.city[1][0].cellType=CellType.Street;
        city3.city[1][1].cellType=CellType.Street;
        city3.city[1][2].cellType=CellType.Bilding;
        city3.city[1][3].cellType=CellType.P;city3.city[1][3].index=0;
        city3.city[1][4].cellType=CellType.Bilding;
        city3.city[1][5].cellType=CellType.Street;
        city3.city[1][6].cellType=CellType.Street;


        city3.city[2][0].cellType=CellType.Street;
        city3.city[2][1].cellType=CellType.Street;
        city3.city[2][2].cellType=CellType.Bilding;
        city3.city[2][3].cellType=CellType.Street;
        city3.city[2][4].cellType=CellType.Bilding;
        city3.city[2][5].cellType=CellType.Street;
        city3.city[2][6].cellType=CellType.Street;

        city3.city[3][0].cellType=CellType.D;city3.city[3][0].index=0;
        city3.city[3][1].cellType=CellType.Street;
        city3.city[3][2].cellType=CellType.Street;
        city3.city[3][3].cellType=CellType.P;  city3.city[3][3].index=1;
        city3.city[3][4].cellType=CellType.Street;
        city3.city[3][5].cellType=CellType.Street;
        city3.city[3][6].cellType=CellType.D; city3.city[3][6].index=1;

        city3.calcNumPacksge();
        cities.add(city3);

        return cities;
    }
    public static void main(String[] args) {
	// write your code here

       ArrayList<City> cities=buidCity();
       for(int i=0;i<cities.size();i++){
           System.out.println(i);
           cities.get(i).print();
           System.out.println("______________________________");
       }
       Scanner input=new Scanner(System.in);
       int choice=input.nextInt();
        cities.get(choice).print();
        System.out.println("______________________________");
        Controller controller=new Controller();
  //      System.out.println("uniform cost search");
    //   controller.ucs(cities.get(choice));
//       System.out.println("A* heurestic1");
//        controller.A_star1(cities.get(choice));
      System.out.println("A* heurestic3");
        controller.A_star(cities.get(choice));
//        System.out.println("_________________________________________________________________");

      /*  while(!controller.end(city)){
            Scanner input=new Scanner(System.in);
            int x=input.nextInt();
            if(x==8){
                controller.move(city,Direction.U);
                city.print();
            }
            else if(x==2){
                controller.move(city,Direction.D);
                city.print();
            }
            else if(x==4){
                controller.move(city,Direction.L);
                city.print();
            }
            else if(x==6){
                controller.move(city,Direction.R);
                city.print();
            }
        }*/

   }
}
