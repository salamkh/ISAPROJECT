package com.company;

import java.util.ArrayList;

public class City implements Comparable<City> {
    City father;
    Cell city [][];
    ArrayList<Integer> packagP;
    ArrayList<Integer> packagD;
    int step;
    int cost;
    int r,c;
    int x,y,xStart,yStart;
    int numPacksge=0;
    City(){
      r=3;
      c=3;
      step=0;
      city=new Cell [r][c];
      packagP=new  ArrayList<Integer>();
      packagD=new  ArrayList<Integer>();
      cost=step+packagP.size()-packagD.size();

    };
    City(int r,int c){
        this.r=r;
        this.c=c;
        step=0;
        city=new Cell [this.r][this.c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++) {
              this.city[i][j]=new Cell() ;
            }
            }
        packagP=new  ArrayList<Integer>();
        packagD=new  ArrayList<Integer>();
        cost=step+packagP.size()-packagD.size();

    }
    public City copy(){
        City c2=new City(this.r,this.c);
        for(int i=0;i<this.r;i++){
            for(int j=0;j<this.c;j++){
               c2.city[i][j].cellType=this.city[i][j].cellType;
               c2.city[i][j].index=this.city[i][j].index;
            }
        }
        for(int l=0;l<this.packagP.size();l++){
            c2.packagP.add(this.packagP.get(l));
        }
        for(int k=0;k<this.packagD.size();k++){
            c2.packagD.add(this.packagD.get(k));
        }
        c2.step=this.step;
        c2.cost=this.cost;
        c2.numPacksge=this.numPacksge;
        c2.xStart=this.xStart;
        c2.yStart=this.yStart;
        c2.x=this.x;
        c2.y=this.y;
        return c2;
    }

    public void calcNumPacksge(){
        for(int i=0;i<this.r;i++){
            for(int j=0;j<this.c;j++){
                if(this.city[i][j].cellType==CellType.P){
                    this.numPacksge++;
                }
            }
        }
    }

    public void print(){
        for(int i=0;i<r;i++) {
            System.out.print("|");
            for (int j = 0; j < c; j++) {
               if(city[i][j].cellType==CellType.Bilding){
                   System.out.print("#");
                   System.out.print("|");
               }
               else  if(city[i][j].cellType==CellType.Street){
                   if(x==i && y==j)
                   {
                       System.out.print("T");
                       System.out.print("|");
                   }
                   else
                   {
                       System.out.print(".");
                       System.out.print("|");
                   }

               }
                else if(city[i][j].cellType==CellType.P){
                   if (this.packagP.contains(city[i][j].index) ){
                       System.out.print("*");
                   }
                   if(x==i && y==j) {

                           System.out.print("T");
                           System.out.print("P" + city[i][j].index);
                           System.out.print("|");

                   }
                   else
                   {
                       System.out.print("P"+city[i][j].index);
                       System.out.print("|");
                   }
                }
               else if(city[i][j].cellType==CellType.D){
                   if (this.packagD.contains(city[i][j].index) ){
                       System.out.print("*");
                   }
                   if(x==i && y==j)
                   {
                       System.out.print("T");
                       System.out.print("D"+city[i][j].index);
                       System.out.print("|");
                   }
                   else
                   {
                       System.out.print("D"+city[i][j].index);
                       System.out.print("|");
                   }

               }
            }

            System.out.println(" ");
        }
    }

    public boolean isEqual(City c2){
        for(int i=0;i<this.r;i++){
            for(int j=0;j<this.c;j++){
               if( c2.city[i][j].cellType!=this.city[i][j].cellType || c2.city[i][j].index!=this.city[i][j].index)
               return false;
            }
        }
        if (this.packagP.size()!=c2.packagP.size()){
            return false;
        }
            for (int l = 0; l < this.packagP.size(); l++) {
                if (/*c2.packagP.size() > 0 &&*/ c2.packagP.get(l) != this.packagP.get(l)) {
                    return false;
                }
            }
        if (this.packagD.size()!=c2.packagD.size()){
            return false;
        }
            for (int k = 0; k < this.packagD.size(); k++) {
                if (/*c2.packagD.size() > 0 &&*/ c2.packagD.get(k) != this.packagD.get(k)) {
                    return false;
                }
            }
     if(c2.xStart!=this.xStart ||
        c2.yStart!=this.yStart ||
        c2.x!=this.x ||
        c2.y!=this.y){
          return false;
        }
      return true;
    }
    @Override
    public int compareTo(City o) {
        if(cost>o.cost)
            return 1;
        if(cost<o.cost)
            return -1;
        else
            return 0;
    }
}
