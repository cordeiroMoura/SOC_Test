package br.com.soc.commons;

import java.util.Random;

public class Generators {
	
	public static String sorteiaReclamacao(){
		
		String valueBusca = "branco/informática/tecnologia/SOC/AGE";				
	
		String[] valuesBusca = valueBusca.split("/");
	
		String buscaSorteada;

		Random random = new Random();

		int intervalo_randomEstado = random.nextInt(valuesBusca.length);

		buscaSorteada = valuesBusca[intervalo_randomEstado];

		return buscaSorteada;		
	}	
	
	public static String geradorCPF() {

		StringBuilder cpfNumberGenerated = new StringBuilder();

		Random random = new Random();

		int[] myarray = new int[9];

		for (int i = 0; i < 9; i++) {
			myarray[i] = (int) (Math.random() * 9);

		}

		int baseCalculation1 = 10;
		int baseCalculation2 = 11;

		int firstDigit[] = new int[9];
		int firstDigit1;
		int secondDigit1;

		for (int j = 0; j < 9; j++) {

			firstDigit[j] = myarray[j] * baseCalculation1;

			baseCalculation1 = baseCalculation1 - 1;

		}

		firstDigit1 = firstDigit[0] + firstDigit[1] + firstDigit[2] + firstDigit[3] + firstDigit[4] + firstDigit[5]
				+ firstDigit[6] + firstDigit[7] + firstDigit[8];

		firstDigit1 = firstDigit1 % 11;

		if (firstDigit1 < 2) {

			firstDigit1 = 0;

		} else {

			firstDigit1 = 11 - firstDigit1;

		}

		int secondDigit[] = new int[10];

		secondDigit[0] = myarray[0];
		secondDigit[1] = myarray[1];
		secondDigit[2] = myarray[2];
		secondDigit[3] = myarray[3];
		secondDigit[4] = myarray[4];
		secondDigit[5] = myarray[5];
		secondDigit[6] = myarray[6];
		secondDigit[7] = myarray[7];
		secondDigit[8] = myarray[8];
		secondDigit[9] = firstDigit1;

		for (int h = 0; h < 10; h++) {

			secondDigit[h] = secondDigit[h] * baseCalculation2;

			baseCalculation2 = baseCalculation2 - 1;

		}

		secondDigit1 = secondDigit[0] + secondDigit[1] + secondDigit[2] + secondDigit[3] + secondDigit[4]
				+ secondDigit[5] + secondDigit[6] + secondDigit[7] + secondDigit[8] + secondDigit[9];

		secondDigit1 = secondDigit1 % 11;

		if (secondDigit1 < 2) {

			secondDigit1 = 0;

		} else {

			secondDigit1 = 11 - secondDigit1;

		}

		cpfNumberGenerated.append(myarray[0]);
		cpfNumberGenerated.append(myarray[1]);
		cpfNumberGenerated.append(myarray[2]);
		cpfNumberGenerated.append(myarray[3]);
		cpfNumberGenerated.append(myarray[4]);
		cpfNumberGenerated.append(myarray[5]);
		cpfNumberGenerated.append(myarray[6]);
		cpfNumberGenerated.append(myarray[7]);
		cpfNumberGenerated.append(myarray[8]);
		cpfNumberGenerated.append(firstDigit1);
		cpfNumberGenerated.append(secondDigit1);

		System.out.println("Numero de cpf gerado: " + cpfNumberGenerated);

		return String.valueOf(cpfNumberGenerated);

	}

	public static String generatorNumberAddress() {

		Random random = new Random();

		String numberAddress;

		int random2 = 1 + (int) (Math.random() * 999);

		numberAddress = Integer.toString(random2);

		return numberAddress;

	}

	public static String generateTel() {

		Random random = new Random();

		String numberTelefone;
		String ddd = "11/12/13/14/15/";

		// Gera DDD
		String[] ddds = ddd.split("/");
		String codDDD;
		String codDDDI;

		int intervalo_randomDDD = random.nextInt(ddds.length);
		int intervalo_randomDDI = random.nextInt(ddds.length);

		codDDD = ddds[intervalo_randomDDD];
		codDDDI = ddds[intervalo_randomDDI];

		// geratelefone

		int random2 = 111111111 + (int) (Math.random() * 100000000);

		numberTelefone = codDDD + random2;

		System.out.println(numberTelefone);

		return numberTelefone;
	}

	public static String generateText() {

		StringBuilder geraNum = new StringBuilder();

		String text = "Text Text Text Text";
		String words = "ABCDEFGHIJKLMNOPQRSTUVYWXZ";

		Random random = new Random();

		String armazenaChaves = "";
		int index = -1;
		for (int i = 0; i < 5; i++) {
			index = random.nextInt(words.length());
			armazenaChaves += words.substring(index, index + 1);
		}

		geraNum.append((text + armazenaChaves));

		return geraNum.toString();

	}

	public static String generateAddressTypePublicPlace() {

		String tipologradouro = "Av/Rua/Viela/beco/";
		String logradourotipoCompleto;
		tipologradouro = tipologradouro.toUpperCase();
		String[] tipologradouros = tipologradouro.split("/");
		Random random = new Random();

		int intervalo_randomLogradouro = random.nextInt(tipologradouros.length);

		logradourotipoCompleto = tipologradouros[intervalo_randomLogradouro];

		return logradourotipoCompleto;

	}

	public static String generateAddressPublicPlace() {

		String logradouro = "jose paiva/Falcoes/benfica/pouso rendondo/monteiro lobato/sao miguel/araujo/1/das petunias/margarida/das margaridas/faria lima/assuncao/santos dummont/assis"
				+ "ribeiro/pacajus/estrada velha/afonso cunha/santa lucia/santa ifigeniaa";

		String logradouroCompleto;

		logradouro = logradouro.toUpperCase();
		String[] logradouros = logradouro.split("/");

		Random random = new Random();

		int intervalo_randomCidades = random.nextInt(logradouros.length);

		logradouroCompleto = logradouros[intervalo_randomCidades];

		return logradouroCompleto;

	}

	public static String generateAddressComplement() {

		String Complemento = "Proximo a Padaria/Esquina com a rua xxx/Atras posto Ipiranga/Seguindo na avenida principal/Na rua debaixo do mercado";

		String nomeComplemento;

		Complemento = Complemento.toUpperCase();
		String[] complementos = Complemento.split("/");

		Random random = new Random();

		int intervalo_randomCidades = random.nextInt(complementos.length);

		nomeComplemento = complementos[intervalo_randomCidades];

		return nomeComplemento;

	}

	public static String generateNeighborHood() {

		String cidade = "Vila Paraiso/Vila Isabel/Pq Industrial/Pimentas/Jardim Cumbica/Santo amaro/Alvorada/Nova Cumbica/Ottawa/Uirapuru/Estela/Presidente dutra/Cocaia"
				+ "Saudade/Vila Olimpia/Reboucas/Vila Madalena/Vila Mariana/Carandiru/Santana/Pacaembu/Barra Funda/Armenia/Luz";

		String nomeCidade;

		cidade = cidade.toUpperCase();
		String[] cidades = cidade.split("/");

		Random random = new Random();

		int intervalo_randomCidades = random.nextInt(cidades.length);

		nomeCidade = cidades[intervalo_randomCidades];

		return nomeCidade;

	}

	public static String generateStates() {

		String estado = "sao paulo/rio de janeiro/goias/minas gerais/tocatins/para/parana/ceara/sergipe/alagoas/maranhao/piaui/rio grande do norte/mato grosso"
				+ "mato grosso do sul/acre/amazonas/amapa/roraima/rondonia/brasilia/rio grande do sul/bahia/pernambuco/paraiba/santa catarina";

		// estado = estado.toUpperCase();
		String[] estados = estado.split("/");
		String nomeEstado;

		Random random = new Random();

		int intervalo_randomEstado = random.nextInt(estados.length);

		nomeEstado = estados[intervalo_randomEstado];

		return nomeEstado;

	}

	public static String generateCity() {

		String cidade = "Guarulhos/jacarepagua/guinazes/Osacos/Aphaville/Acajutiba/Acopiara/Araguari/Borborema/Guara/Guarupava/Iguatemi/Ipatinga"
				+ "Itabuna/Itamarati/Itapeva/Itu/Jundia/Maua/Pacaembu/Paranapanema/Piracicaba/Paranabiacaba/Uberaba";

		String nomeCidade;

		cidade = cidade.toUpperCase();
		String[] cidades = cidade.split("/");

		Random random = new Random();

		int intervalo_randomCidades = random.nextInt(cidades.length);

		nomeCidade = cidades[intervalo_randomCidades];

		return nomeCidade;

	}

	

	public static String genrateTextReplicate() {

		String complaint = "Estou no aguardo da resposta referente ao meu problema/Ainda no aguardo do envio do produto/Eu não vou nem falar nada"
				+ "/O produto comprado não é o entregue/ ";

		String complaintSort;

		String[] complaints = complaint.split("/");

		Random random = new Random();

		int intervalo_randomComplaint = random.nextInt(complaints.length);

		complaintSort = complaints[intervalo_randomComplaint];

		return complaintSort;

	}

	public static String generateEmail() {

		String nomeEmail = "teste/reclameaqui/ra/reclame/robo/automation/regression/chapolin/chaves/magneto/wolverine/ciclops/tamandua_bandeira/churruminos/gui_triloko/fazourro/acaboujessica";
		String dominioEmail = "hotmail.com/yahoo.com/hotmail.com.br/yahoo.com.br/gmail.com/gmail.com.br/adasfa.com/bbbbb.com/kkkk.com.br/jjjjj.com/nuncaserao.com.br/xxx123.com/";
		String emailCompleto;
		int num;

		String[] nomesEmails = nomeEmail.split("/");
		String[] dominiosEmails = dominioEmail.split("/");

		Random random = new Random();

		int intervalo_randomnomeEmail = random.nextInt(nomesEmails.length);
		int intervalo_randomdominioEmail = random.nextInt(dominiosEmails.length);
		int intervaloNumericoEmail = random.nextInt(99);

		emailCompleto = nomesEmails[intervalo_randomnomeEmail] + intervaloNumericoEmail + "@"
				+ dominiosEmails[intervalo_randomdominioEmail];
		return emailCompleto;

	}

	public static String generateNumberDecimal() {

		Random random = new Random();

		String numeroInteiro;

		int random2 = 1 + (int) (Math.random() * 999);
		int random3 = 1 + (int) (Math.random() * 999);

		numeroInteiro = random2 + "." + random3;

		return numeroInteiro;

	}

	public static String generateNumberInt() {

		Random random = new Random();

		String numeroInteiro;

		int random2 = 1 + (int) (Math.random() * 9999);

		numeroInteiro = Integer.toString(random2);

		return numeroInteiro;

	}

	public static String generateListUF() {

		String UF = "AC/AL/AP/AM/BA/CE/DF/ES/GO/MA/MT/MS/MG/PA/PB/PR/PE/PI/RJ/RN/RS/RO/RR/SC/SP/SE/TO";

		UF = UF.toUpperCase();
		String[] UFs = UF.split("/");
		String nomeUF;

		Random random = new Random();

		int intervalo_randomEstado = random.nextInt(UFs.length);

		nomeUF = UFs[intervalo_randomEstado];

		return nomeUF;

	}

	public static String generateDate() {

		String DataCompleta;
		String verificaDia;

		Random random = new Random();

		int dia = 01 + (int) (Math.random() * 30);
		int mes = 01 + (int) (Math.random() * 12);
		int ano = 1940 + (int) (Math.random() * 120);

		if (ano > 1996) {

			ano = 1996;
		}

		String d = Integer.toString(dia);
		String m = Integer.toString(mes);
		String a = Integer.toString(ano);

		if (d.length() < 2) {

			d = "0" + d;
		}

		if (m.length() < 2) {

			m = "0" + m;
		}

		DataCompleta = d + m + a;

		return DataCompleta;
	}

	public static String generateGender() {

		String genero = "masculino/feminino";

		genero = genero.toUpperCase();
		String[] generos = genero.split("/");
		String generoCompleto;

		Random random = new Random();

		int intervalo_randomEstado = random.nextInt(generos.length);

		generoCompleto = generos[intervalo_randomEstado];

		return generoCompleto;

	}

	public static String generateMaritalStatus() {

		String EstadoCivil = "Solteiro/Divorciado/Casado/Viuvo";

		String[] estadosCivil = EstadoCivil.split("/");
		String EstadoCivilCompleto;

		Random random = new Random();

		int intervalo_randomEstado = random.nextInt(estadosCivil.length);

		EstadoCivilCompleto = estadosCivil[intervalo_randomEstado];

		return EstadoCivilCompleto;

	}

	public static String generateCEP() {

		String numeroCEP = "03212000/07241090/05305012";

		String[] numerosCeps = numeroCEP.split("/");
		String CEP;

		Random random = new Random();

		int intervalo_randomCEP = random.nextInt(numerosCeps.length);

		CEP = numerosCeps[intervalo_randomCEP];

		return CEP;

	}

	public static String generateNames() {

		String PrimeiroNome;

		String nome = "/Andre/Diego/Dalva/jose/ze/maria/joana/rafael/millena/aline/andressa/guilherme/gustavo/lucas/fernanda/fernando/matheus/jonas/joaquina/mirella/antonio/chico/cleber/pietro/pamela/henrique/vanessa/adriana/aline/eunice/paulo"
				+ " dalva/fabiane/lourdes/stephanne/kelly/carla/wesley/jonathan/vinicius/michel/rafaela/cintia/felipe/jackson/bruno/daivid/emerson/rogerio/luciano/luciana/margarida/melina/melissa/margaret/monica/gabriel/lenadro/steve/denis/";
		// String sobrenome =
		// "carvalho/cardoso/silva/lima/costa/calleone/ferreira/santana/santos/souza/batista/soares/vidotti/perreira/ferraz/braga/coelho/"
		// +
		// "araujo/correia/guimaraes/assis/palhares/antunes/boleta/mata/garcia/alves/meneghetti/bizo/justino/queiroz/ramos/viana/dantas/miranda/teixeira/monteiro";

		nome = nome.toUpperCase();
		// sobrenome = sobrenome.toUpperCase();

		String[] nomes = nome.split("/");
		// String[] sobrenomes = sobrenome.split("/");

		System.out.println(nomes.length);

		Random random = new Random();

		int intervalo_randomiconome = random.nextInt(nomes.length);
		// int intervalo_randomicosobrenome = random.nextInt(sobrenomes.length);

		PrimeiroNome = nomes[intervalo_randomiconome];

		return PrimeiroNome;

	}

	public static String generateSurnames() {

		String sobrenome = ""
				+ "abreu/almeida/altoe/alvez/amaral/amorim/araujo/azevedo/aguiar/airoso/akechi/albino/alcantra/alvarez/antunes/botelho/braga/\n"
				+ "    braum/barone/correia/cabral/cardoso/costa/cassaro/cassini/correia/corradi/chaves/carrermartins/camacho/carvalho/cardoso/silva/lima/costa/calleone/ferreira/santana/santos/souza/batista/soares/vidotti/perreira/ferraz/braga/coelho/"
				+ "araujo/correia/guimaraes/assis/palhares/antunes/boleta/mata/garcia/alves/meneghetti/bizo/justino/queiroz/ramos/viana/dantas/miranda/teixeira/monteiro";
		sobrenome = sobrenome.toUpperCase();

		String[] sobrenomes = sobrenome.split("/");

		Random random = new Random();
		int intervalo_randomicosobrenome = random.nextInt(sobrenomes.length);

		sobrenome = sobrenomes[intervalo_randomicosobrenome];
		return sobrenome;

	}

}
