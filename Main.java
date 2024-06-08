import java.io.IOException;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class  Main extends ConnectApi {
	public static void main(String[] args) throws IOException, InterruptedException {
		Gson gson = new GsonBuilder().create();
		ConnectApi connect = new ConnectApi();

	Scanner leitura = new Scanner(System.in);
	int option = 0;
    Double convert;
	String menu = """
		==========================================================
		Conversor de moeda, escolha uma opção abaixo.
		Digite 1 para converter de Real (BRL) para Dolar (USD);
		Digite 2 para converter de Dolar (USD) para Real (BRL);
		Digite 3 para converter de Real (BRL) para Euro (EUR);
		Digite 4 para converter de Euro (EUR) para Real (BRL);
		Digite 5 para converter de Real (BRL) para Iene (JPY);
		Digite 6 para converter de Iene (JPY) para Real (BRL);
		Digite 7 para sair;
		===========================================================
		""";
		while (option != 7){
		System.out.println(menu);
		option = leitura.nextInt();

			if (option == 1) {
				System.out.println("Digite o valor para ser convertido: ");
				Double money = leitura.nextDouble();
				connect.dataCurrency("BRL", "USD");
				convert = connect.getValue().conversion_rate() * money;
				System.out.println("O valor em Reais R$" + money + " convertido em para Dólar ficou U$" + convert);
			} else if (option == 2){
				System.out.println("Digite o valor para ser convertido: ");
				Double money = leitura.nextDouble();
				connect.dataCurrency("USD", "BRL");
				convert = connect.getValue().conversion_rate() * money;
				System.out.println("O valor em Dólar U$" + money + " convertido em para Reais ficou R$" + convert);
			} else if (option == 3){
				System.out.println("Digite o valor para ser convertido: ");
				Double money = leitura.nextDouble();
				connect.dataCurrency("BRL", "EUR");
				convert = connect.getValue().conversion_rate() * money;
				System.out.println("O valor em Real R$" + money + " convertido em para Euro ficou €$" + convert);
			} else if (option == 4){
				System.out.println("Digite o valor para ser convertido: ");
				Double money = leitura.nextDouble();
				connect.dataCurrency("EUR", "BRL");
				convert = connect.getValue().conversion_rate() * money;
				System.out.println("O valor em Euro €$" + money + " convertido em para Real ficou R$" + convert);
			} else if (option == 5){
				System.out.println("Digite o valor para ser convertido: ");
				Double money = leitura.nextDouble();
				connect.dataCurrency("BRL", "JPY");
				convert = connect.getValue().conversion_rate() * money;
				System.out.println("O valor em Real R$" + money + " convertido em para Iene ficou ¥$" + convert);
			} else if (option == 6){
				System.out.println("Digite o valor para ser convertido: ");
				Double money = leitura.nextDouble();
				connect.dataCurrency("JPY", "BRL");
				convert = connect.getValue().conversion_rate() * money;
				System.out.println("O valor em Iene ¥$" + money + " convertido em para Real ficou R$" + convert);
			} else if (option == 7){
			System.out.println("Encerrado o programa!");
			} else {
			System.out.println("Opção inválida!");
			}
		}
	}
}
