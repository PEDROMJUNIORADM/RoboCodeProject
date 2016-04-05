package optimus;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import robocode.RobocodeFileOutputStream;


public class FileController {
	
	private static final int SHOT_DIRETION_INDEX = 0;
	private static final int ESCAPE_DIRETION_INDEX = 1;
	private static final int ANGULE_ESCAPE_INDEX = 2;
	private static final int TIME_RESISTENCE_INDEX = 3;
	
	public FileController(){}
	
	/**
	 * Read a file, the file structure is like this
	 * [ [SHOT_DIRETION, ESCAPE_DIRETION, ANGULE_ESCAPE, TIME_RESISTENCE],
	 * 	 [SHOT_DIRETION, ESCAPE_DIRETION, ANGULE_ESCAPE, TIME_RESISTENCE],
	 *                        .................
	 *   [SHOT_DIRETION, ESCAPE_DIRETION, ANGULE_ESCAPE, TIME_RESISTENCE] ] 
	 *   
	 * @return a list of escapes postions
	 * @throws Exception
	 */
	public static List<EscapePosition> readFile() throws Exception{
		File file = new File("C:/robocode/robots/optimus/Optimus.data/positionsEscape.txt");
		List<EscapePosition> posicoesFuga = new ArrayList<EscapePosition>();
		if (file.exists()) {
			Scanner s = new Scanner(file);
			Pattern pattern = Pattern.compile("\\d+;\\d+;\\d+;\\d+\\.\\d+\\|");
			while(s.hasNext()){
				String posicao = s.next(pattern);
				String[] posicoes = posicao.split(";");
				EscapePosition posicaoFuga = new EscapePosition();
				posicaoFuga.setShotDiretion(Integer.parseInt(posicoes[SHOT_DIRETION_INDEX]));
				posicaoFuga.setEscapeDiretion(Integer.parseInt(posicoes[ESCAPE_DIRETION_INDEX]));
				posicaoFuga.setAngleEscape(Integer.parseInt(posicoes[ANGULE_ESCAPE_INDEX]));
				posicaoFuga.setTimeOfResistance(Double.parseDouble(posicoes[TIME_RESISTENCE_INDEX].substring(0, posicoes[TIME_RESISTENCE_INDEX].length()-1)));
				posicoesFuga.add(posicaoFuga);
			}
			s.close();
		}
		return posicoesFuga;
	}
	
	
	/**
	 * Feed the file with information about de robot`s positions.
	 * 
	 * @param positionsEscape
	 * @throws IOException
	 */
	public static void reacordFile(List<EscapePosition> positionsEscape) throws IOException{
		
		File file = new File("C:/robocode/robots/optimus/Optimus.data/positionsEscape.txt");
		RobocodeFileOutputStream fos = null;
		try {
			fos = new RobocodeFileOutputStream(file);
			for (EscapePosition posicaoFuga : positionsEscape) {
				fos.write(posicaoFuga.toString().getBytes());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		fos.close();
	}

}
