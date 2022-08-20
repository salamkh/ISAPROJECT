package com.company;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Collections;

 public class Controller {

     public boolean canmove(City city, Direction direction) {

         if (direction == Direction.U && city.x != 0) {
             if (city.city[city.x - 1][city.y].cellType != CellType.Bilding)
                 return true;
         }
         if (direction == Direction.D && city.x != city.r - 1) {
             if (city.city[city.x + 1][city.y].cellType != CellType.Bilding)
                 return true;
         }
         if (direction == Direction.R && city.y != city.c - 1) {
             if (city.city[city.x][city.y + 1].cellType != CellType.Bilding)
                 return true;
         }
         if (direction == Direction.L && city.y != 0) {
             if (city.city[city.x][city.y - 1].cellType != CellType.Bilding)
                 return true;
         }
         return false;

     }

     public City move(City city, Direction direction) {
         if (canmove(city, direction)) {
             if (direction == Direction.U) {
                 city.x--;
             }
             if (direction == Direction.D) {
                 city.x++;
             }
             if (direction == Direction.R) {
                 city.y++;
             }
             if (direction == Direction.L) {
                 city.y--;
             }
             boolean exist = false;
             boolean exist2 = false;
             if (city.city[city.x][city.y].cellType == CellType.P) {
                 for (int i = 0; i < city.packagP.size(); i++) {
                     if (city.packagP.get(i) == city.city[city.x][city.y].index) {
                         exist = true;
                     }
                 }
                 if (!exist) {
                     city.packagP.add(city.city[city.x][city.y].index);
                 }
             }

             if (city.city[city.x][city.y].cellType == CellType.D) {
                 for (int i = 0; i < city.packagP.size(); i++) {
                     if (city.packagP.get(i) == city.city[city.x][city.y].index) {
                         exist = true;
                     }
                 }
                 if (exist) {
                     for (int i = 0; i < city.packagD.size(); i++) {
                         if (city.packagD.get(i) == city.city[city.x][city.y].index) {
                             exist2 = true;
                         }
                     }
                     if (!exist2)
                         city.packagD.add(city.city[city.x][city.y].index);
                 }
             }
             city.step++;
             city.cost = city.step + city.packagP.size() - city.packagD.size();
         }
         return city;
     }

     public boolean end(City city) {
         if (city.x == city.xStart && city.y == city.yStart) {
             if (city.packagP.size() == city.packagD.size() && city.packagD.size() == city.numPacksge) {
                 return true;
             }
         }
         return false;
     }

     public ArrayList<City> children(City city) {
         City c;
         ArrayList<City> child = new ArrayList<City>();
         if (city.x >= 0 && canmove(city, Direction.U)) {
             c = new City();
             c = city.copy();
             move(c, Direction.U);
             c.father = city;
             child.add(c);
         }
         if (city.x <= city.r - 1 && canmove(city, Direction.D)) {
             c = new City();
             c = city.copy();
             move(c, Direction.D);
             c.father = city;
             child.add(c);
         }
         if (city.y >= 0 && canmove(city, Direction.L)) {
             c = new City();
             c = city.copy();
             move(c, Direction.L);
             c.father = city;
             child.add(c);
         }
         if (city.y <= city.c - 1 && canmove(city, Direction.R)) {
             c = new City();
             c = city.copy();
             move(c, Direction.R);
             c.father = city;
             child.add(c);
         }
         return child;
     }
     public void ucs(City city) {
         double start = System.currentTimeMillis();
         int count =0;
         ArrayList<City> path = new ArrayList<City>();
         PriorityQueue<City> pq = new PriorityQueue<City>();
         ArrayList<City> visited = new ArrayList<City>();
         ArrayList<City> child = new ArrayList<City>();
         City coco = new City(city.r, city.c);
         pq.add(city);
         boolean e=false;
         while (!pq.isEmpty()) {
             coco = pq.poll();
             count++;
             visited.add(coco);
             if (end(coco)) {
                 e=true;
                 while (coco.father != null) {
                     path.add(coco);
                     coco = coco.father;
                 }
                 break;
             }

             child = children(coco);
             boolean v=false;
                for (int i = 0; i < child.size(); i++) {
                    v=false;
                    for (int j = 0; j < visited.size(); j++) {
                            if (visited.get(j).isEqual(child.get(i))) {
                               v=true;
                               break;
                            }
                    }
                    if(!v){
                        pq.add(child.get(i));
                    }
                }
         }
         double end = System.currentTimeMillis();
         if (!e){
         System.out.println("Impssible to solve");
         }
         else {
             Collections.reverse(path);
             for (int i = 0; i < path.size(); i++) {
                 System.out.println(i);
                 System.out.println("________________________________");
                 path.get(i).print();
                 System.out.println("________________________________");
             }
             System.out.println("executimg time="+ ((end-start)/1000));
             System.out.println("cost="+ path.get(path.size()-1).cost);
             System.out.println("number of nodes="+ count);
         }
     }
     public double huristic1 (City c){
         return (c.x- c.xStart)+(c.y-c.yStart);
     }
     public double huristic2(City c ,int xP,int yP,int xD,int yD){
         if(c.packagP.contains(c.city[xP][yP].index) && c.packagD.contains(c.city[xD][yD].index)){
             return (c.x- c.xStart)+(c.y-c.yStart);
         }
         if(c.packagP.contains(c.city[xP][yP].index) && !c.packagD.contains(c.city[xD][yD].index)){
             return ((c.x-xD)-(c.y-yD))+((xD-c.xStart)-(yD-c.yStart));
         }
         return ((c.x-xP)+(c.y-yP))+((xP-xD)-(yP-yD))+((xD-c.xStart)-(yD-c.yStart));
     }
     public double huristic3(City c){
         int xP=0, yP=0,xD=0, yD=0 ;
         double max=Integer.MIN_VALUE;
         for(int i=0;i<c.numPacksge;i++){
             for(int j=0;j<c.r;j++){
                 for(int k=0;k<c.c;k++){
                     if(c.city[j][k].index==i && c.city[j][k].cellType==CellType.P){
                         xP=j;
                         yP=k;
                     }
                     if(c.city[j][k].index==i && c.city[j][k].cellType==CellType.D){
                         xD=j;
                         yD=k;
                     }
                 }
             }
             if(max<huristic2(c,xP,yP,xD,yD)){
                 max=huristic2(c,xP,yP,xD,yD) ;
             }
         }
         return max;
     }
     public void A_star(City city) {
         double start = System.currentTimeMillis();
         int count =0;
         ArrayList<City> path = new ArrayList<City>();
         PriorityQueue<City> pq = new PriorityQueue<City>();
         ArrayList<City> visited = new ArrayList<City>();
         ArrayList<City> child = new ArrayList<City>();
         City coco = new City(city.r, city.c);
         pq.add(city);
         boolean e=false;
         while (!pq.isEmpty()) {
             coco = pq.poll();
             count++;
             visited.add(coco);
             if (end(coco)) {
                 e=true;
                 while (coco.father != null) {
                     path.add(coco);
                     coco = coco.father;
                 }
                 break;
             }

             child = children(coco);
             boolean v=false;
                for (int i = 0; i < child.size(); i++) {
                    child.get(i).cost+=huristic3(child.get(i));
                    v=false;
                    for (int j = 0; j < visited.size(); j++) {
                            if (visited.get(j).isEqual(child.get(i))) {
                               v=true;
                               break;
                            }
                    }
                    if(!v){
                        pq.add(child.get(i));
                    }
                }
         }
         double end = System.currentTimeMillis();
         if (!e){
         System.out.println("Impssible to solve");
         }
         else {
             System.out.println(path.size());
             Collections.reverse(path);
             for (int i = 0; i < path.size(); i++) {
                 System.out.println(i);
                 System.out.println("________________________________");
                 path.get(i).print();
                 System.out.println("________________________________");
             }
             System.out.println("executimg time="+ ((end-start)/1000));
             System.out.println("cost="+ path.get(path.size()-1).cost);
             System.out.println("number of nodes="+ count);

         }
     }
     public void A_star1(City city) {
         double start = System.currentTimeMillis();
         int count =0;
         ArrayList<City> path = new ArrayList<City>();
         PriorityQueue<City> pq = new PriorityQueue<City>();
         ArrayList<City> visited = new ArrayList<City>();
         ArrayList<City> child = new ArrayList<City>();
         City coco = new City(city.r, city.c);
         pq.add(city);
         boolean e=false;
         while (!pq.isEmpty()) {
             coco = pq.poll();
             count++;
             visited.add(coco);
             if (end(coco)) {
                 e=true;
                 while (coco.father != null) {
                     path.add(coco);
                     coco = coco.father;
                 }
                 break;
             }

             child = children(coco);
             boolean v=false;
             for (int i = 0; i < child.size(); i++) {
                 child.get(i).cost+=huristic1(child.get(i));
                 v=false;
                 for (int j = 0; j < visited.size(); j++) {
                     if (visited.get(j).isEqual(child.get(i))) {
                         v=true;
                         break;
                     }
                 }
                 if(!v){
                     pq.add(child.get(i));
                 }
             }
         }
         double end = System.currentTimeMillis();
         if (!e){
             System.out.println("Impssible to solve");
         }
         else {
             System.out.println(path.size());
             Collections.reverse(path);
             for (int i = 0; i < path.size(); i++) {
                 System.out.println(i);
                 System.out.println("________________________________");
                 path.get(i).print();
                 System.out.println("________________________________");
             }
             System.out.println("executimg time="+ ((end-start)/1000));
             System.out.println("cost="+ path.get(path.size()-1).cost);
             System.out.println("number of nodes="+ count);

         }
     }
 }
