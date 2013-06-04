package br.com.caelum.vraptor.util;
import org.apache.commons.lang3.StringUtils;


final public class BuscaBr {
	
	final static String vogais = "aaaaaeeeeiiiiooooouuuu";
	final static String vogaisAcentuadas = "áâàãäéêèëíîìïóõòôöúùûü";
	
	final static String[] lista01 = 		{"y","br","bl","ph","gr","gl","mg","ng","rg","ge","gi","rj","mj","nj","q","ca","co","cu","ck","c","lh","n","rm","gm","md","sm"};
	final static String[] lista01Troca = 	{"i","b","b","f","g","g","g","g","g","j","j","j","j","j","k","k","k","k","k","k","l","m","m","m","m","m"};
	
	final static String[] lista02 = 		{"nh","pr","ç","ce","ci","ch","x","ts","cs","c","z","rs","lt","tr","ct","rt","st","w","l"};
	final static String[] lista02Troca = 	{"n","p","s","s","s","s","s","s","s","s","s","s","t","t","t","t","t","v","r"};
	
	final static String[] lista03 = 	 {"h","aa","bb","cc","dd","ee","ff","gg","hh","ii","jj","kk","ll","mm","nn","oo","pp","qq","rr","ss","tt","uu","vv","ww","xx","yy","zz"};
	final static String[] lista03Troca = {"","a","","","","e","","","","i","","","l","m","n","","p","","r","s","t","","","","","",""};
	//lista03Troca original
	//final static String[] lista03Troca = {"","","","","","","","","","","","","","","","","","","","","","","","","","",""};
	
	final static String[] lista04 = 	{"a","e","i","o","u"};
	final static String[] lista04Troca = 	{"","","","",""};

	public static String buscaBr(String entrada){
		entrada = entrada.toLowerCase();
		entrada = entrada.trim();
		String textoBuilder = entrada;
		StringBuilder stringFinal = new StringBuilder();
		
		
		String[] frase = StringUtils.split(textoBuilder); 
		
		for (int i = 0; i < frase.length; i++) {
			textoBuilder = frase[i].trim();
			textoBuilder = StringUtils.replaceChars(textoBuilder, vogaisAcentuadas, vogais);
			textoBuilder = StringUtils.replaceEach(textoBuilder, lista01, lista01Troca);
			textoBuilder = StringUtils.replaceEach(textoBuilder, lista02, lista02Troca);
			
			if (StringUtils.substring(textoBuilder, -1).equals("s")) 
				textoBuilder = StringUtils.substring(textoBuilder, 0, -1);
			
			if (StringUtils.substring(textoBuilder, -1).equals("z")) 
				textoBuilder = StringUtils.substring(textoBuilder, 0, -1);
			
			if (StringUtils.substring(textoBuilder, -1).equals("r")) 
				textoBuilder = StringUtils.substring(textoBuilder, 0, -1);
			
			if (StringUtils.substring(textoBuilder, -1).equals("m")) 
				textoBuilder = StringUtils.substring(textoBuilder, 0, -1);
			
			if (StringUtils.substring(textoBuilder, -1).equals("n")) 
				textoBuilder = StringUtils.substring(textoBuilder, 0, -1);
			
			if (StringUtils.substring(textoBuilder, -2).equals("ao")) 
				textoBuilder = StringUtils.substring(textoBuilder, 0, -2);
			
			if (StringUtils.substring(textoBuilder, -1).equals("l")) 
				textoBuilder = StringUtils.substring(textoBuilder, 0, -1);
			
			
			textoBuilder = StringUtils.replaceEach(textoBuilder, lista03, lista03Troca);
		  //Neste ponto é possivel retirar todas as vogais, simplinficando ainda mais o codigo fonético.
		  //textoBuilder = StringUtils.replaceEach(textoBuilder, lista04, lista04Troca);
			
			stringFinal.append(textoBuilder+" ");
			
		}	
		return stringFinal.toString();
	}
	
	
}
