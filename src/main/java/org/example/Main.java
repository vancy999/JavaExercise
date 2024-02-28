package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }

        int a = 10;
        int b = 2;
        float c = 3;
        String nama = "Irvan";
        char q = 'Y';
        boolean flag = false;

        int result;
        float result1;
        result = a/b; //10 dibagi 2 (sama sama int)
        result1 = a/c; //10 dibagi 3 (salah satu float)
        System.out.println(result);
        System.out.println(result1);


        int timeStart = 8;
        int timeFinish = 17;
        int waktuDatang = 9;
        int waktuPulang = 14;
        //karyawan tepat waktu datang dan pulang
        //dapat selamat, karyawan telat disoraki.
        //karyawan telat, pulang lama, dimaafkan
        //karyawan datang duluan, pulang cepat, dihantam bos
        if(waktuDatang <= timeStart && waktuPulang >= timeFinish){
            System.out.println("selamat kamu tepat waktu");
            System.out.println("kamu datang " + (timeStart - waktuDatang) + " jam lebih cepat");
            System.out.println("kamu pulang " + (waktuPulang - timeFinish) + " jam lebih lama");
            //karyawan datang duluan, pulang duluan
        } else if (waktuDatang <= timeStart && waktuPulang <= timeFinish) {
            System.out.println("Cepet dateng cepet pulang");
            //karyawan telat, pulang lama, dimaafkan
        } else if (waktuDatang >= timeStart && waktuPulang > timeFinish) {
            System.out.println("GAPAPA TELAT PULANGNYA LAMA SOALNYA");
        } else{
            System.out.println("MENDING PULANG BANG UDAH TELAT " + (waktuDatang - timeStart) + " JAM");
            System.out.println("MASIH ADA " + (timeFinish - waktuPulang) + " JAM INI BOS SEBELUM PULANG");
        }

        int day = 3;
        switch (day) {
            case 1:
                System.out.println("Saya WFO");
                break;
            case 2:
                System.out.println("Saya Libur");
                break;
            case 3:
                System.out.println("Saya WFH");
                break;
            default:
                System.out.println("Weekend");
                break;
        }
    }

    //loop
    //while , for loop dan foreach

}