package p4;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 * author@Ian Turnbull
 * version@11-26-16
 * 
 * LeagueofLegends will display the most recent 5 games added to the featured games list in the League of Legends game. 
 * It will display the type of game, the amount of time played, the game id, and the 10 players in the game.
 */
public class LeagueofLegends {

	/**
	 * Main method contains code to create the frame and labels that contains all the updates and GUI. The method also
	 * will use the readURL method to create JSONObjects and JSONArrays in order for the data to be interpreted.
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
		JFrame frame = new JFrame("League of Legends Featured Games");
		frame.setSize(700,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		try {
			frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Ian\\OneDrive\\2016 FALL\\ITEC220\\p4\\p4\\src\\p4\\frameBG.png")))));
		}catch(IOException e) {
			System.out.println("background image not found.");
		}
		
		JLabel _gameType = new JLabel("",SwingConstants.CENTER);
		_gameType.setBounds(296,200,100,20);
		_gameType.setFont(new Font("Friz Quadrata", Font.PLAIN, 22));
		_gameType.setForeground(Color.BLACK);
		
		JLabel _gameId = new JLabel("",SwingConstants.CENTER);
		_gameId.setBounds(275,350,150,20);
		
		JLabel _gameLength = new JLabel("",SwingConstants.CENTER);
		_gameLength.setBounds(296,230,100,20);
		_gameLength.setFont(new Font("Friz Quadrata", Font.PLAIN, 22));
		_gameLength.setForeground(Color.BLACK);
		
		JLabel player1 = new JLabel("",SwingConstants.CENTER);
		player1.setBounds(40,200,225,30);
		player1.setFont(new Font("Friz Quadrata", Font.PLAIN, 22));
		player1.setForeground(Color.RED);
		
		JLabel player2 = new JLabel("",SwingConstants.CENTER);
		player2.setBounds(40,230,225,30);
		player2.setFont(new Font("Friz Quadrata", Font.PLAIN, 22));
		player2.setForeground(Color.RED);
		
		JLabel player3 = new JLabel("",SwingConstants.CENTER);
		player3.setBounds(40,260,225,30);
		player3.setFont(new Font("Friz Quadrata", Font.PLAIN, 22));
		player3.setForeground(Color.RED);
		
		JLabel player4 = new JLabel("",SwingConstants.CENTER);
		player4.setBounds(40,290,225,30);
		player4.setFont(new Font("Friz Quadrata", Font.PLAIN, 22));
		player4.setForeground(Color.RED);
		
		JLabel player5 = new JLabel("",SwingConstants.CENTER);
		player5.setBounds(40,320,225,30);
		player5.setFont(new Font("Friz Quadrata", Font.PLAIN, 22));
		player5.setForeground(Color.RED);
		
		JLabel player6 = new JLabel("",SwingConstants.CENTER);
		player6.setBounds(435,200,225,30);
		player6.setFont(new Font("Friz Quadrata", Font.PLAIN, 22));
		player6.setForeground(Color.BLUE);
		
		JLabel player7 = new JLabel("",SwingConstants.CENTER);
		player7.setBounds(435,230,225,30);
		player7.setFont(new Font("Friz Quadrata", Font.PLAIN, 22));
		player7.setForeground(Color.BLUE);
		
		JLabel player8 = new JLabel("",SwingConstants.CENTER);
		player8.setBounds(435,260,225,30);
		player8.setFont(new Font("Friz Quadrata", Font.PLAIN, 22));
		player8.setForeground(Color.BLUE);
		
		JLabel player9 = new JLabel("",SwingConstants.CENTER);
		player9.setBounds(435,290,225,30);
		player9.setFont(new Font("Friz Quadrata", Font.PLAIN, 22));
		player9.setForeground(Color.BLUE);
		
		JLabel player10 = new JLabel("",SwingConstants.CENTER);
		player10.setBounds(435,320,225,30);
		player10.setFont(new Font("Friz Quadrata", Font.PLAIN, 22));
		player10.setForeground(Color.BLUE);
		
		frame.add(_gameType);
		frame.add(_gameId);
		frame.add(_gameLength);
		frame.add(player1);
		frame.add(player2);
		frame.add(player3);
		frame.add(player4);
		frame.add(player5);
		frame.add(player6);
		frame.add(player7);
		frame.add(player8);
		frame.add(player9);
		frame.add(player10);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		boolean done = false;
		
		while(!done) {
			
		String JSonString = readURL("https://na1.api.riotgames.com/lol/spectator/v3/featured-games?api_key=RGAPI-6c96e32b-bd5d-4738-be99-cc025e249db2");
		
		JSONObject x = JSONObject.fromObject(JSonString);
		JSONArray featured = x.getJSONArray("gameList"); 
		for (int i = 0; i < ((JSONArray) featured).toArray().length; i++) {
		    JSONObject jsonobject = featured.getJSONObject(i);
		    
		    JSONArray players = jsonobject.getJSONArray("participants");
	         for (int j = 0; j < ((JSONArray)players).toArray().length; j++) {
	              JSONObject participants = players.getJSONObject(j);
	              String summoner = participants.getString("summonerName");
	              
	              switch(j) {
	              
	              case 0: player1.setText(summoner);
	              		  break;
	              case 1: player2.setText(summoner);
	                      break;
	              case 2: player3.setText(summoner);
	                      break;
	              case 3: player4.setText(summoner);
	                      break;
	              case 4: player5.setText(summoner);
	                      break;
	              case 5: player6.setText(summoner);
	                      break;
	              case 6: player7.setText(summoner);
	                      break;
	              case 7: player8.setText(summoner);
	                      break;
	              case 8: player9.setText(summoner);
	                      break;
	              case 9: player10.setText(summoner);
	                      break;
	              }
	         }
	         
		    String gameID = jsonobject.getString("gameId");
		    String gameMode = jsonobject.getString("gameMode");
		    String gameLength = jsonobject.getString("gameLength");
		    _gameId.setText("gameId: " + gameID);
		    _gameType.setText(gameMode);
		    
		    int time = Integer.parseInt(gameLength);
		    int minutes = (time % 3600) / 60;
		    int seconds = time % 60;
		    String timeString = String.format("%02d:%02d", minutes, seconds);
		    _gameLength.setText(timeString);
		    
		    Thread.sleep(5000);
		    
		}
		
		}
		
	}
	
	/**
	 * readURL reads the URL provided and returns the data contained.
	 * @param webservice, URL from Riot Games API
	 * @return String with JSON data.
	 * @throws Exception
	 */
	public static String readURL(String webservice) throws Exception {
		  URL oracle = new URL(webservice);
		  BufferedReader in = new BufferedReader(
		        new InputStreamReader(
		        oracle.openStream()));

		  String inputLine;
		  String result = "";

		  while ((inputLine = in.readLine()) != null)
		      result = result + inputLine;

		  in.close();
		  return result;
		}
}