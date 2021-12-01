package fr.lernejo.logger;

public class LoggerFactory {

    public static Logger getLogger(String name){
        Logger logger = new FileLogger("./logs.txt");
        return new ContextualLogger(name, logger);

    }
}
