package ca.bcit.comp2522.innerClasses;

/**
 * A service performs jobs.
 */
interface Service {

    /**
     * Performs the first job.
     */
    void firstJob();

    /**
     * Performs the second job.
     */
    void secondJob();
}

/**
 * A ServiceFactory produces a Service to perform jobs.
 */
interface ServiceFactory {

    /**
     * Returns a Service to perform jobs.
     * @return service an implementation of the Service interface
     */
    Service getService();
}

/**
 * PrintingService is an implementation of the Service interface.
 */
final class PrintingService implements Service {

    /**
     * Check this out. It's a public static variable. Static means it's always available
     * even before a PrintingService is instantiated. This is an anonymous ServiceFactory
     * object.
     */
    public static final ServiceFactory PRINTING_SERVICE_FACTORY = new ServiceFactory() {

        /**
         * Returns an instance of the PrintingService.
         * @return printingService an instance of PrintingService.
         */
        @Override
        public Service getService() {
            return new PrintingService();
        }
    };

    private PrintingService() {
    }

    /**
     * Performs the first job.
     */
    @Override
    public void firstJob() {
        System.out.println("Printing the colour version!");
    }

    /**
     * Performs the second job.
     */
    @Override
    public void secondJob() {
        System.out.println("Printing the B&W version!");
    }
}

/**
 * CookingService is an implementation of the Service interface.
 */
final class CookingService implements Service {

    /**
     * Check this out. It's a public static variable. Static means it's always available
     * even before a PrintingService is instantiated. This is an anonymous ServiceFactory
     * object.
     */
    public static final ServiceFactory COOKING_SERVICE_FACTORY = new ServiceFactory() {

        /**
         * Returns an instance of the CookingService.
         * @return cookingService an instance of CookingService.
         */
        @Override
        public Service getService() {
            return new CookingService();
        }
    };

    private CookingService() {
    }

    /**
     * Performs the first job.
     */
    @Override
    public void firstJob() {
        System.out.println("Whipping up some jjapaguri!");
    }

    /**
     * Performs the second job.
     */
    @Override
    public void secondJob() {
        System.out.println("Roasting some curried kabocha!");
    }
}

/**
 * Shows us how to use abstract factories. This is a very cool design pattern.
 *
 * @author BCIT
 * @version 2026
 */
public final class Factories {

    private Factories() {
    }

    /*
     * A service consumer accepts a factory as a parameter, extracts a
     * service from the factory, and then asks the service to act.
     * @param serviceFactory an implementation of ServiceFactory
     */
    static void serviceConsumer(final ServiceFactory serviceFactory) {
        Service s = serviceFactory.getService();
        s.firstJob();
        s.secondJob();
    }

    /**
     * Drives the program.
     * @param args unused.
     */
    public static void main(final String[] args) {
        serviceConsumer(PrintingService.PRINTING_SERVICE_FACTORY);
        // Implementations are completely interchangeable:
        serviceConsumer(CookingService.COOKING_SERVICE_FACTORY);
    }
}
