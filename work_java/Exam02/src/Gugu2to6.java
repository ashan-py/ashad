
public class Gugu2to6 {

    public static void main(String[] args) throws java.io.IOException {
        //System.out.print("input gugudan(2~6)");
        int rdDan;
        int sum;
        
        
//        rdDan = System.in.read() - 48;
//        while (rdDan < 2 || rdDan>6) {
//            System.in.read();
//            System.out.print("Gugudan=" + rdDan + ",wrong input T.T; reinput(2~6)");
//            rdDan = System.in.read() -48;
//            
//        }
        rdDan = -1;
        while (true) {
            if (rdDan != 10 && rdDan != 13)
                System.out.print("input Gugudan(2~6)");
            rdDan = System.in.read();
            if (rdDan >= '2' && rdDan<='6')
                break;
        }
        rdDan -=48;
        for (int i = 2; i <10; i++)
            System.out.printf("%d*%d=%2d\n", rdDan, i, rdDan * i);
        

    }

}