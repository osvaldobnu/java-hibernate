import hibernate.dao.PessoaDAO;
import hibernate.model.Pessoa;

public class Main {

	public static void main(String[] args) {
		try {
			PessoaDAO dao = new PessoaDAO();
			
			/* Pessoa pessoa = new Pessoa("Amanda Pereira", "amanda@pereira", 58);
			dao.criarPessoa(pessoa);
			
			pessoa.setNome("Luizinha popoca");
			dao.alteraPessoa(pessoa);
			
			Pessoa pessoa = dao.getPessoa(4);
			
			pessoa.setNome("Deise manteiga");
			
			dao.alteraPessoa(pessoa);
			
			System.out.println(pessoa.getNome());*/
			
			dao.deletaPessoa(3);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
