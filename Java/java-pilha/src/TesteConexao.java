
public class TesteConexao {
	public static void main(String[] args) {
		// ------- MODO ANTIGO
//		Conexao conexao = null;		
//		try {
//			conexao = new Conexao();
//			conexao.leDados();
//		} catch (Exception e) {
//			System.out.println("Deu erro na conexao..");
//		} finally {
//			conexao.fecha();
//		}
		
		// ------ MODO NOVO
		try(Conexao conexao = new Conexao() ){
		    conexao.leDados();
		} catch(Exception ex){
		    System.out.println("Deu erro na conexão");
		}
	}
}
