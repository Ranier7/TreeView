package application.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.address.model.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class TreeViewController implements Initializable{
	
	@FXML
	TreeView <String> treeView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		try {
            String url = "http://localhost:8080/api/modelos";

            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();

            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                System.out.println("Erro " + conn.getResponseCode() + " ao obter dados da URL " + url);
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String line = br.readLine();
            
            conn.disconnect();

            Gson gson = new Gson();
            TypeToken typeToken = new TypeToken<List<Model>>() {};
            
            List<Model> model = gson.fromJson(line, typeToken.getType());

            TreeItem<String> root = new TreeItem<>("Portfólio");
            
            TreeItem<String> nodeA = new TreeItem<>("Linha Apolo");
    		TreeItem<String> nodeB = new TreeItem<>("Linha Cronos");
    		TreeItem<String> nodeC = new TreeItem<>("Linha Ares");
    		TreeItem<String> nodeD = new TreeItem<>("Linha Zeus");
    		
    		for(Model modelo : model) {
    			
    			String linha = modelo.getLinha();
    			
    			if(linha.contentEquals("Apolo")) {
    				nodeA.getChildren().addAll(new TreeItem<String>(modelo.getModelo()));
    			}
    			if(linha.contentEquals("Cronos")) {
    				nodeB.getChildren().addAll(new TreeItem<String>(modelo.getModelo()));
    			}
    			if(linha.contentEquals("Ares")) {
    				nodeC.getChildren().addAll(new TreeItem<String>(modelo.getModelo()));
    			}
    			if(linha.contentEquals("Zeus")) {
    				nodeD.getChildren().addAll(new TreeItem<String>(modelo.getModelo()));
    			}
    			
    		}
    		
    		root.getChildren().addAll(nodeA,nodeB,nodeC,nodeD);
    		treeView.setRoot(root);
    		treeView.setShowRoot(false);
    		
        } catch (IOException e) {
            System.out.println("Sem conexão!");
        }
    
		
		
		
		/*TreeItem<String> root = new TreeItem<>("Portfólio");
		
		TreeItem<String> nodeA = new TreeItem<>("Linha Apolo");
		TreeItem<String> nodeB = new TreeItem<>("Linha Cronos");
		TreeItem<String> nodeC = new TreeItem<>("Linha Ares");
		TreeItem<String> nodeD = new TreeItem<>("Linha Zeus");
		root.getChildren().addAll(nodeA,nodeB,nodeC,nodeD);
		
		TreeItem<String> nodeA1 = new TreeItem<>("Apolo 6031");
		nodeA.getChildren().add(nodeA1);
		
		TreeItem<String> nodeB1 = new TreeItem<>("Cronos 6001-A");
		TreeItem<String> nodeB2 = new TreeItem<>("Cronos 6021-A");
		TreeItem<String> nodeB3 = new TreeItem<>("Cronos 6021L");
		TreeItem<String> nodeB4 = new TreeItem<>("Cronos 6003");
		TreeItem<String> nodeB5 = new TreeItem<>("Cronos 7023");
		TreeItem<String> nodeB6 = new TreeItem<>("Cronos 7023L");
		TreeItem<String> nodeB7 = new TreeItem<>("Cronos 7023 2,5");
		nodeB.getChildren().addAll(nodeB1,nodeB2,nodeB3,nodeB4,nodeB5,nodeB6,nodeB7);
		
		TreeItem<String> nodeC1 = new TreeItem<>("Ares 7021");
		TreeItem<String> nodeC2 = new TreeItem<>("Ares 7031");
		TreeItem<String> nodeC3 = new TreeItem<>("Ares 7023");
		TreeItem<String> nodeC4 = new TreeItem<>("Ares 8023");
		TreeItem<String> nodeC5 = new TreeItem<>("Ares 8023 15");
		TreeItem<String> nodeC6 = new TreeItem<>("Ares 8023 200");
		nodeC.getChildren().addAll(nodeC1,nodeC2,nodeC3,nodeC4,nodeC5,nodeC6);
		
		TreeItem<String> nodeD1 = new TreeItem<>("Zeus 8021");
		TreeItem<String> nodeD2 = new TreeItem<>("Zeus 8031");
		TreeItem<String> nodeD3 = new TreeItem<>("Zeus 8023");
		nodeD.getChildren().addAll(nodeD1,nodeD2,nodeD3);
		
		treeView.setRoot(root);
		treeView.setShowRoot(false);*/
		
	}

}
