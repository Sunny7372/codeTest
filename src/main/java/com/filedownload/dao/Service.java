package com.filedownload.dao;

import java.util.ArrayList;
import java.util.List;

public class Service {
    public static void main(String[] args) {
        getData();
    }



        public static void getData () {
            Acknowledge ack = new Acknowledge();
            List<AtrData>l1=new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                processData(ack, i,l1);
            }
            //for(int z=0;z<ack.getData().size();z++){
                //ack.getData().toString();
            //}
            System.out.println(ack.getData());
        }

        public static void processData (Acknowledge ack,int i,List<AtrData>l1){
            if (i < 5) {
                //List<AtrData> atr = new ArrayList<>();
                AtrData tr = new AtrData();
                tr.setAge("24");
                tr.setName("Sunny");
                tr.setLspId("1");
                tr.setMobileNumber("6709876890");
                l1.add(tr);
                ack.setBankId("123412302");
                ack.setData(l1);

            }
        }
    }



