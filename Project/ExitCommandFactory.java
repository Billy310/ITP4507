public class ExitCommandFactory implements CommandFactory{

public Command create(){
return new ExitCommand();
}
}