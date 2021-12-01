public class Multithreading {
    public static void main(String[] args) {

        Print p = new Print();

        //创建两个线程
        //线程1
        new Thread(new Runnable() {
            public void run() {
                while (p.flag1) {
                    p.print1();
                }
            }
        }).start();

        //线程2
        new Thread(new Runnable() {
            public void run() {
                while (p.flag2) {
                    p.print2();
                }
            }
        }).start();

    }
}

class Print {
    private Object obj = new Object();//锁对象
    private boolean b = true;//b的初始值为true

    //测试数组
//    int[] arr1 = {1, 3, 5, 7, 9};
//    int[] arr2 = {2, 4, 6, 8, 10, 12, 14};

    int[] arr1 = {1, 3, 5, 7, 9, 11, 13, 15};
    int[] arr2 = {2, 4, 6, 8, 10};

//    int [] arr1 = {};
//    int [] arr2 = {2,4,6};

//    int [] arr1 = {2,4,6};
//    int [] arr2 = {};

    int countArray1 = 0;//数组1的计数器
    int countArray2 = 0;//数组2的计数器

    //用flag判断该线程是否继续
    boolean flag1 = true;
    boolean flag2 = true;

    /*
    1、创建同步代码块
    2、判断数组书否输出完
        a、若未输出完
            使用等待唤醒机制输出该数组内容
            countArray++
        b、若输出完
            则唤醒并改变b的boolean值，b=!b,进入另一线程方法
    */

    //用方法1输出数组1
    public void print1() {
        synchronized (obj) {//同步代码块
            if (countArray1 < arr1.length) {
                if (!b) {
                    //数组1先输出
                    try {
                        obj.wait();//等待,释放锁对象
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(arr1[countArray1] + "  ");//输出数组arr1的下一个数字
                countArray1++;
                b = false;
            } else {
                flag1 = false;b = false;//线程1已经输出完了，关闭线程1
            }
            obj.notify();//唤醒
            if (countArray2 >= arr2.length) {//如果另一线程还没输出完，则不需要改变b的值
                b = true;
            }
        }
    }

    //用方法2输出数组2
    public void print2() {
        synchronized (obj) {
            if (countArray2 < arr2.length) {
                if (b) {
                    try {
                        obj.wait();//等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(arr2[countArray2] + "  ");
                countArray2++;
                b = true;
            } else {
                flag2 = false;b = true;//线程2已经输出完了，关闭线程2
            }
            obj.notify();//唤醒
            if (countArray1 >= arr1.length) {//如果另一线程还没输出完，则不需要改变b的值
                b = false;
            }
        }
    }
}