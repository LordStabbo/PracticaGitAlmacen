package PackagePracticaGithub;

public class AppAlmacenGit {
	public static void main (String[] args) {
		int opcion;//esta variable servira para elegir las opciones del switch
		int uds;//con esta variable podré operar con las unidades en el stock
		almacen almacen01 = new almacen(101, 100);
		int salir = 0;//esta variable se utilizara para salir del do...while del try...catch
		int salirProg = 0;/*esta variable la utilizara el do...while con el que es posible
		implementar la opcion "salir"*/
		Scanner sc = new Scanner(System.in);
		
		do { //este do...while permite cerrar el programa cuando se elige la opcion "salir"
			do {
				/*Aqui hago un try...catch que reinicia el programa si el usuario itroduce um valor
				 * incorrecto
				 */
				try {
					//estas son las diferentes opciones con las que podrá operar el programa
					System.out.println("Elige una de las siguientes opciones:");
					System.out.println("1) Checkear stock de camisas");
					System.out.println("2) Añadir camisas al stock");
					System.out.println("3) Restar al stock camisas que se han vendido");
					System.out.println("4) Checkear stock de pantalones");
					System.out.println("5) Añadir pantalones al stock");
					System.out.println("6) Restar al stock pantalones que se han vendido");
					System.out.println("7) Salir.)");

					salir = 0;
					opcion = sc.nextInt(); //instancio un scanner 

					switch (opcion) { //con este switch se operaran las diferentes opciones que ofrece el programa

					case 1:
						/*esta opcion imprimira mediante un getter la cantidad de camisas que hay en el stock, y 
						 * mediante una serie de if´s y else if´s avisara al usuarop de la urgencia con la que hay
						 * que reponer el stock en funcion de la cantidad que haya en este
						 */
						System.out.println("El almacén tiene " + almacen01.dameCamisas() + " camisas");
						if (almacen01.dameCamisas() < 5) {
							System.out.println("Hay que hacer otro pedido");
						} else if (almacen01.dameCamisas() > 5 && almacen01.dameCamisas() < 10) {
							System.out.println("Pronto habra que hacer otro pedido");
						} else if (almacen01.dameCamisas() < 10) {
							System.out.print("Vamos bien de camisas");
						}
						
						break;

					case 2: //este case trabaja con el metodo setter con el que se suman camisas
						System.out.println("¿Cuantas camisas desea añadir?");
						uds = sc.nextInt();
						almacen01.sumaCamisas(uds);
						System.out.println("Has añadido " + uds + " camisas");
						System.out.println("Ahora el almacen tiene" + almacen01.dameCamisas() + " camisas");
						salir = 1;
						break;

					case 3://este case trabaja con el metodo setter con el que se restan camisas
						System.out.println("¿Cuantas camisas de las que ha vendido desea restar al stock?");
						uds = sc.nextInt();
						almacen01.restaCamisas(uds);
						System.out.println("Has vendido " + uds + " camisas");
						System.out.println("Ahora el almacen tiene" + almacen01.dameCamisas() + " camisas");
						salir = 1;
						break;

					case 4:
						/*esta opcion imprimira mediante un getter la cantidad de pantalones que hay en el stock, y 
						 * mediante una serie de if´s y else if´s avisara al usuarop de la urgencia con la que hay
						 * que reponer el stock en funcion de la cantidad que haya en este
						 */
						System.out.println("El almacen tiene " + almacen01.damePantalones() + " pantalones");
						if (almacen01.damePantalones() < 5) {
							System.out.println("Hay que hacer otro pedido de pantalones");
						} else if (almacen01.damePantalones() > 5 && almacen01.damePantalones() < 10) {
							System.out.println("Pronto habra que hacer otro pedido");
						} else if (almacen01.damePantalones() < 10) {
							System.out.print("Vamos bien de pantalones");
						}
						break;

					case 5://este case trabaja con el metodo setter con el que se suman pantalones
						System.out.println("¿Cuantos pantalones desea añadir al stock");
						uds = sc.nextInt();
						almacen01.sumaPantalones(uds);
						System.out.println("Has añadido " + uds + " pantalones");
						System.out.println("Ahora el almacen tiene" + almacen01.damePantalones() + " pantalones");
						salir = 1;
						break;

					case 6://este case trabaja con el metodo setter con el que se restan pantalones
						System.out.println("¿Cuantos pantalones de los que ha vendido desea añadir al stock");
						uds = sc.nextInt();
						almacen01.restaPantalones(uds);
						System.out.println("Has vendido " + uds + " pantalones");
						System.out.println("Ahora el almacen tiene" + almacen01.damePantalones() + " pantalones");
						salir = 1;
						break;

					case 7:
						salirProg++;//con esta opcion se cambia la variable con la que se sale del primer do while y, por tanto, del programa
						break;

					default:

						break;
					}
				} catch (ArithmeticException e) {
					System.out.println("El 0 es un valor inválido en este campo");
					System.out.println("El error es " + e.getMessage());
				} catch (InputMismatchException e) {
					System.out.println("Tipo de caracter inválido");
					System.out.println("El error es " + e.getMessage());
				}
				/*con esos catches se recogen tanto las excepciones aritmeticas como las de input incompatible*/

				sc.nextLine();
			} while (salir == 0);
		} while (salirProg == 0);
		sc.close();
	}

}
