public class Main7 {
    public static void main(String[] args) {
        MFP mfp = new MFP();
        new Thread(new Runnable() {
            @Override
            public void run() {
                mfp.print(10);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                mfp.scan(10);
            }
        }).start();



    }
}

