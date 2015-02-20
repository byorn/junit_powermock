package byorn.production.systemframework;

public class Systemframwork {

	private static boolean isInitialized;
	
	
	/** Called during servlet, web container initialization **/
	public void init(){
		this.isInitialized = true;
	}

	
	public static void persist(){
		if(isInitialized){
			//persist
		}else{
			throw new IllegalStateException();
		}
	}
}

