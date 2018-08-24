import java.util.Arrays;
import java.util.Date;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class Principal {
	
	public static void main(String[] args) {
		MongoClient cliente = new MongoClient();
		MongoDatabase bancoDeDados = cliente.getDatabase("test");
		MongoCollection<Document> alunos = bancoDeDados.getCollection("alunos");
		FindIterable<Document> lsAlunos = alunos.find();
		
		for (Document aluno : lsAlunos) {
			System.out.println(aluno);
		}
		//System.out.println(aluno);
		
//		Document novoAluno = new Document("nome", "Leticia")
//			.append("data_nascimento" , new Date(2003, 10, 10))
//			.append("curso" , new Document("nome", "Historia"))
//			.append("notas" , Arrays.asList(10,9,8))
//			.append("habilidades", Arrays.asList(new Document()
//													.append("nome"  , "Ingles ")
//													.append("nível" , "Básico"),
//													new Document()
//													.append("nome" , "Espanhol")
//													.append("nível" , "Básico")));
//		
//		alunos.insertOne(novoAluno);
		
//		alunos.updateOne(Filters.eq("nome", "Julia"), new Document("$set", new Document("dataNascimento" , new Date(2017, 04, 11))));
		
//		alunos.deleteOne(Filters.eq("nome" , "Joao Silva"));
		
		cliente.close();
	}

}
