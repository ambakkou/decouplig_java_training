package fr.lernejo.logger;

public class LoggerFactory {

    public static Logger getLogger(String name){
        Logger filelogger = new FileLogger("./logs.txt");
        return new CompositeLogger(new ContextualLogger(name,new ConsoleLogger()), new ContextualLogger(name,filelogger));

    }
}
