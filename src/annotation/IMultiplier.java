package annotation;
@ExtractInterface("IMultiplier")
public class IMultiplier {

	public int multiply(int x,int y){
		int total = 0;
		for(int i = 0; i < x; i++)
			total = add(total,y);
		return total;
	}
	private int add(int x,int y){
		return x + y;
	}

	public static void main(String[] args){
		IMultiplier m = new IMultiplier();
		System.out.println("11*16 = " + m.multiply(11, 16));
	}
}
