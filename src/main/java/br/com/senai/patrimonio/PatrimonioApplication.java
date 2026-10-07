package br.com.senai.patrimonio;

import br.com.senai.patrimonio.atividades.*;
import br.com.senai.patrimonio.avaliacao.Participante;
import br.com.senai.patrimonio.avaliacao.enums.Nivel;
import br.com.senai.patrimonio.model.*;
import br.com.senai.patrimonio.model.Funcionario;
import br.com.senai.patrimonio.model.enums.Cargo;
import br.com.senai.patrimonio.model.enums.EstadoConservacao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PatrimonioApplication {

	public static void main(String[] args) {

		SpringApplication.run(PatrimonioApplication.class, args);

		Empresa empresa = new Empresa();
		empresa.setRazaoSocial("Senai LTDA");
		System.out.println(empresa.getRazaoSocial());

		Endereco endereco = new Endereco();
		endereco.setRua("Bela vista");
		System.out.println(endereco.getRua());
		System.out.println(endereco.getBairro());

		empresa.setEndereco(endereco);
		System.out.println(empresa.getEndereco().getRua());

		Endereco enderecoComArgumentos = new Endereco("Líbano jose gomes",
				"489", "Perto do posto de saúde",
				"Santa luzia", "Criciúma", "SC");
		System.out.println(enderecoComArgumentos.getBairro());

		Sala sala = new Sala();

		Funcionario funcionario = new Funcionario(
				35L, "Mariazinha", "13456789",
				Cargo.GERENTE, empresa, sala
		);

		System.out.println(funcionario.getCpf());

		Participante participante = new Participante(
				"João", "joao@gmail.com", "04898745236",
				"45678", Nivel.INICIANTE
		);

		Empresa empresaIterface = new Empresa();
		Bloco blocoInterface = new Bloco(1L, "Bloco 2", empresaIterface);
		Sala salaInterface = new Sala(2L, "Sala 28", "46789",
				blocoInterface, empresaIterface);

		System.out.println(salaInterface.getDescricaoLocalizavel());

		Patrimonio patrimonio= new Patrimonio();

		System.out.println(patrimonio.validarEstadoConservacao());

		patrimonio.setEstado(EstadoConservacao.REGULAR);
		System.out.println(patrimonio.validarEstadoConservacao());

		System.out.println("***************TESTE BEM*********");
		Bem bem=new Bem();
		System.out.println(bem.getEmpresaVinculada());
		Empresa empresa1= new Empresa();
		bem.setEmpresa(empresa1);
		System.out.println(bem.getEmpresaVinculada());

		empresa1.setNome("SENAI");
		System.out.println(bem.getEmpresaVinculada());

		System.out.println("************TESTE DE BLOCO*****************");

		Bloco bloco=new Bloco();
		System.out.println(bloco.getEmpresaVinculada());
		Empresa empresa2=new Empresa();
		bloco.setEmpresa(empresa2);
		System.out.println(bloco.getEmpresaVinculada());
		empresa2.setNome("ALUMASA");
		System.out.println(bloco.getEmpresaVinculada());

		System.out.println("*********TESTE DE FUNCIONARIO*******************");

		Funcionario funcionario1=new Funcionario("Kossi", 50000.0);
		System.out.println(funcionario1.getEmpresaVinculada());
		Empresa empresa3=new Empresa();
		funcionario1.setEmpresa(empresa3);
		System.out.println(funcionario1.getEmpresaVinculada());
		empresa3.setNome("BISTEK");
		funcionario1.setEmpresa(empresa3);
		System.out.println(funcionario1.getEmpresaVinculada());

		System.out.println("******TESTE DA SALA*****************");

		Sala sala1=new Sala();
		System.out.println(sala1.getEmpresaVinculada());
		Empresa empresa4=new Empresa();
		sala1.setEmpresa(empresa4);
		System.out.println(sala1.getEmpresaVinculada());
		empresa4.setNome("UNESC");
		sala1.setEmpresa(empresa4);
		System.out.println(sala1.getEmpresaVinculada());

		System.out.println("*******//////////////////******************");

		Pessoa pessoa=new Pessoa();
		pessoa.setNome("Elianazinha");
		pessoa.setCpf("45258458687");
		System.out.println(pessoa.getIdentificacao());
		System.out.println("************************");
		funcionario1.setNome("Mikelvski");
		funcionario1.setCpf("1312141525");
		funcionario1.setCargo(Cargo.DIRETOR);
		System.out.println(funcionario1.getIdentificacao());


		Equipamento equipamento=new Equipamento("Mesa",800.00);
		Equipamento computador=new Computador("Notebook",5000.00);
		Equipamento veiculo=new Veiculo("Avensis",98000.00);

		exibirRelatorio(equipamento);
		exibirRelatorio(computador);
		exibirRelatorio(veiculo);

		br.com.senai.patrimonio.atividades.Funcionario funcionario2=
				new br.com.senai.patrimonio.atividades.Funcionario("Kossi",50000.00);
		br.com.senai.patrimonio.atividades.Funcionario gerente=
				new Gerente("Eliana",75000.00);
		br.com.senai.patrimonio.atividades.Funcionario desenvolvedor=
				new Desenvolvedor("Mathea",30000.00);

		imprimirContraCheque(funcionario2);
		imprimirContraCheque(gerente);
		imprimirContraCheque(desenvolvedor);
	}
public static void exibirRelatorio(Equipamento item){
	System.out.println("Item: " + item.getNome());
	System.out.println("Valor Inicial:  " + item.getValorInicial());
	System.out.println("Depreciação:  "+ item.calcularDepreciacao());
	System.out.println("**********************************");



}
	// Método auxiliar que demonstra o polimorfismo
	public static void imprimirContraCheque(br.com.senai.patrimonio.atividades.Funcionario f) {
		System.out.println("Funcionário: " + f.getNome());
		System.out.println("Salário Base: R$ " + f.getSalarioBase());
		System.out.println("Bonifiçao: R$ " + f.calcularBonificacao());
		System.out.println("Total: R$ "+(f.getSalarioBase()+ f.calcularBonificacao()));

		// TODO 3: Imprimir a bonificação chamando f.calcularBonificacao()

		// TODO 4: Imprimir o Salário Total (Salário Base + Bonificação)

		System.out.println("---------------_________----------------");
	}
}



