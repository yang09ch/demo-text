package cn.kgc.yang.expetion.code;

public class ServiceExpetion extends Exception {
    public ServiceExpetion() {
    }
    public ServiceExpetion(String message) {
        super(message);
    }

    public ServiceExpetion(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceExpetion(Throwable cause) {
        super(cause);
    }

    public ServiceExpetion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
