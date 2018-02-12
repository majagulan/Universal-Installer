package konfiguracioniRezim.actions;



public class ActionManager {
	
	private static ActionManager instance = null;
	private NewProductAction newProd;
	private NewWizardAction newWiz;
	private NewParameterAction newPar;
	private UpdateAction update;
	private SaveAction save;
	private RemoveAction remove;
	private QuitAction quit;
	public NewProductAction getNewProd() {
		return newProd;
	}
	public void setNewProd(NewProductAction newProd) {
		this.newProd = newProd;
	}
	public NewWizardAction getNewWiz() {
		return newWiz;
	}
	public void setNewWiz(NewWizardAction newWiz) {
		this.newWiz = newWiz;
	}
	public NewParameterAction getNewPar() {
		return newPar;
	}
	public void setNewPar(NewParameterAction newPar) {
		this.newPar = newPar;
	}
	public UpdateAction getUpdate() {
		return update;
	}
	public void setUpdate(UpdateAction update) {
		this.update = update;
	}
	public SaveAction getSave() {
		return save;
	}
	public void setSave(SaveAction save) {
		this.save = save;
	}
	public RemoveAction getRemove() {
		return remove;
	}
	public void setRemove(RemoveAction remove) {
		this.remove = remove;
	}
	public QuitAction getQuit() {
		return quit;
	}
	public void setQuit(QuitAction quit) {
		this.quit = quit;
	}
	private ActionManager() {
		super();
		// TODO Auto-generated constructor stub
		newProd = new NewProductAction(AbstractActionIcon.small);
		newWiz = new NewWizardAction(AbstractActionIcon.small);
		newPar = new NewParameterAction(AbstractActionIcon.small);
		update = new UpdateAction(AbstractActionIcon.small);
		save = new SaveAction(AbstractActionIcon.small);
		remove = new RemoveAction(AbstractActionIcon.small);
		quit = new QuitAction(AbstractActionIcon.small);
	
	}
	
	public static ActionManager getInstance() {
		if (instance == null)
			instance = new ActionManager();

		return instance;
	}
	
	
	

}
