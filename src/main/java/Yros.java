public class Yros {

    private static final String DEFAULT_RUN_PORT = "8000";
    private static final String DEFAULT_SERIAL_PORT = "COM1";
    private static final float DEFAULT_SPEED = 2F;
    private static final float[] DEFAULT_START_COORDINATE = {0F,0F};

    private String runPort;
    private String serialPort;
    private Float speed;
    private float[] startCoordinate;

    private static volatile Yros myRos;

    private Yros(Builder builder) {
        this.runPort = builder.runPort;
        this.serialPort = builder.serialPort;
        this.speed = builder.speed;
        this.startCoordinate = builder.startCoordinate;
    }

    //防止builder重复创建
     private static Yros getMyRos(Builder builder){
        if (myRos == null){
            synchronized (Yros.class){
                if (myRos == null){
                    return new Yros(builder);
                }
            }
        }
        return myRos;
    }



    public static final class Builder{
        private String runPort;
        private String serialPort;
        private float speed;
        private float[] startCoordinate;


        public Builder() {
            this.runPort = Yros.DEFAULT_RUN_PORT;
            this.startCoordinate = Yros.DEFAULT_START_COORDINATE;
            this.speed = Yros.DEFAULT_SPEED;
            this.serialPort = Yros.DEFAULT_SERIAL_PORT;
        }

        //todo 参数校验
        public Yros.Builder rosPort(String runPort){
            this.runPort = runPort;
            return this;
        }

        public Yros.Builder serialPort(String serialPort){
            this.serialPort = serialPort;
            return this;
        }

        public Yros.Builder Speed(float speed){
            this.speed = speed;
            return this;
        }

        public Yros.Builder startCoordinate(float[] coor){
            this.startCoordinate = coor;
            return this;
        }

        public Yros start(){
            return Yros.getMyRos(this);
        }


    }
}
