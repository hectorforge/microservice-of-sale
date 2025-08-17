package pe.edu.cibertec.msproductservice.seeders;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.msproductservice.models.Category;
import pe.edu.cibertec.msproductservice.models.Product;
import pe.edu.cibertec.msproductservice.repositories.ProductRepository;
import pe.edu.cibertec.msproductservice.repositories.CategoryRepository;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProductAndCategorySeeder {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @PostConstruct
    public void init() {
        if (productRepository.count() == 0) {
            // Crear categorias
            Category tech = Category.builder().name("Tecnología").build();
            Category home = Category.builder().name("Hogar").build();
            Category sport = Category.builder().name("Deportes").build();
            Category fashion = Category.builder().name("Moda").build();
            Category toys = Category.builder().name("Juguetes").build();
            Category books = Category.builder().name("Libros").build();

            List<Category> categories = Arrays.asList(tech, home, sport, fashion, toys, books);
            categoryRepository.saveAll(categories);

            // Crear productos
            List<Product> products = Arrays.asList(
                    // Tecnologia
                    Product.builder().name("Laptop Lenovo IdeaPad 3").description("Laptop 15.6 pulgadas, 8GB RAM, 512GB SSD").price(2300.00).stock(15).category(tech).build(),
                    Product.builder().name("Smartphone Samsung Galaxy S23").description("Pantalla AMOLED, 128GB almacenamiento").price(3500.00).stock(20).category(tech).build(),
                    Product.builder().name("Tablet Apple iPad 10.2").description("64GB WiFi + Retina Display").price(2000.00).stock(12).category(tech).build(),
                    Product.builder().name("Monitor LG 24'' Full HD").description("Monitor IPS, 75Hz").price(750.00).stock(18).category(tech).build(),
                    Product.builder().name("Auriculares Sony WH-1000XM4").description("Cancelación de ruido").price(1200.00).stock(25).category(tech).build(),
                    Product.builder().name("Mouse Logitech MX Master 3").description("Mouse inalámbrico ergonómico").price(380.00).stock(40).category(tech).build(),
                    Product.builder().name("Teclado Mecánico Redragon").description("Switches blue retroiluminado").price(260.00).stock(30).category(tech).build(),
                    Product.builder().name("Cámara Canon EOS 250D").description("Cámara réflex digital 24MP").price(2900.00).stock(10).category(tech).build(),
                    Product.builder().name("Impresora HP Deskjet Ink Advantage").description("Impresora multifuncional").price(450.00).stock(35).category(tech).build(),
                    Product.builder().name("Smartwatch Amazfit GTR 3").description("Reloj inteligente con GPS").price(700.00).stock(22).category(tech).build(),

                    // Hogar
                    Product.builder().name("Sofá 3 cuerpos gris").description("Sofá de tela color gris oscuro").price(1800.00).stock(8).category(home).build(),
                    Product.builder().name("Mesa de comedor madera").description("Mesa para 6 personas").price(2200.00).stock(6).category(home).build(),
                    Product.builder().name("Silla ergonómica oficina").description("Silla negra ajustable").price(520.00).stock(20).category(home).build(),
                    Product.builder().name("Refrigeradora Samsung 360L").description("Refrigeradora No Frost").price(2800.00).stock(7).category(home).build(),
                    Product.builder().name("Microondas LG 30L").description("Microondas digital plateado").price(420.00).stock(15).category(home).build(),
                    Product.builder().name("Licuadora Oster Pro").description("Licuadora 8 velocidades").price(250.00).stock(18).category(home).build(),
                    Product.builder().name("Aspiradora Xiaomi Mi Robot").description("Aspiradora inteligente").price(1100.00).stock(10).category(home).build(),
                    Product.builder().name("Colchón Queen Size").description("Colchón ortopédico premium").price(1500.00).stock(5).category(home).build(),
                    Product.builder().name("Juego de ollas Tramontina").description("Set de 10 piezas de acero inoxidable").price(750.00).stock(12).category(home).build(),
                    Product.builder().name("Ventilador de torre").description("Ventilador oscilante con control remoto").price(300.00).stock(25).category(home).build(),

                    // Deportes
                    Product.builder().name("Bicicleta Montaña Giant").description("Bicicleta con 21 velocidades").price(1900.00).stock(9).category(sport).build(),
                    Product.builder().name("Balón de fútbol Adidas").description("Balón oficial tamaño 5").price(180.00).stock(30).category(sport).build(),
                    Product.builder().name("Raqueta de tenis Wilson").description("Raqueta ligera y resistente").price(600.00).stock(14).category(sport).build(),
                    Product.builder().name("Guantes de box Everlast").description("Guantes profesionales de boxeo").price(280.00).stock(20).category(sport).build(),
                    Product.builder().name("Cinta de correr Reebok").description("Caminadora eléctrica").price(3500.00).stock(4).category(sport).build(),
                    Product.builder().name("Pesas ajustables 40kg").description("Set de mancuernas ajustables").price(800.00).stock(16).category(sport).build(),
                    Product.builder().name("Casco para ciclismo Giro").description("Casco aerodinámico y seguro").price(350.00).stock(22).category(sport).build(),
                    Product.builder().name("Patines Rollerblade").description("Patines profesionales de 4 ruedas").price(700.00).stock(12).category(sport).build(),
                    Product.builder().name("Tabla de surf Quiksilver").description("Tabla de surf de fibra de vidrio").price(2500.00).stock(5).category(sport).build(),
                    Product.builder().name("Balón de baloncesto Spalding").description("Balón de cuero sintético").price(220.00).stock(18).category(sport).build(),

                    // Moda
                    Product.builder().name("Zapatillas Nike Air Max").description("Zapatillas urbanas color blanco").price(520.00).stock(25).category(fashion).build(),
                    Product.builder().name("Camiseta Polo Ralph Lauren").description("Camiseta 100% algodón").price(280.00).stock(30).category(fashion).build(),
                    Product.builder().name("Pantalón Levi’s 501").description("Jeans azul clásico").price(350.00).stock(22).category(fashion).build(),
                    Product.builder().name("Chaqueta de cuero negra").description("Chaqueta estilo motero").price(1200.00).stock(8).category(fashion).build(),
                    Product.builder().name("Vestido Zara flores").description("Vestido casual estampado floral").price(400.00).stock(15).category(fashion).build(),
                    Product.builder().name("Bolso Michael Kors").description("Bolso de cuero color marrón").price(950.00).stock(12).category(fashion).build(),
                    Product.builder().name("Reloj Casio Vintage").description("Reloj digital dorado").price(180.00).stock(20).category(fashion).build(),
                    Product.builder().name("Gorra New Era NY").description("Gorra ajustable color negro").price(120.00).stock(40).category(fashion).build(),
                    Product.builder().name("Bufanda de lana").description("Bufanda color gris invierno").price(90.00).stock(25).category(fashion).build(),
                    Product.builder().name("Sandalias Havaianas").description("Sandalias de playa unisex").price(70.00).stock(35).category(fashion).build(),

                    // Juguetes
                    Product.builder().name("Lego Star Wars X-Wing").description("Set de construcción de 700 piezas").price(550.00).stock(15).category(toys).build(),
                    Product.builder().name("Muñeca Barbie Dreamhouse").description("Casa de muñecas de 3 pisos").price(950.00).stock(10).category(toys).build(),
                    Product.builder().name("Carro Hot Wheels Pista Turbo").description("Pista con lanzador de autos").price(320.00).stock(20).category(toys).build(),
                    Product.builder().name("Puzzle 1000 piezas").description("Rompecabezas panorámico").price(180.00).stock(30).category(toys).build(),
                    Product.builder().name("Juego de mesa Monopoly").description("Versión clásica de Monopoly").price(250.00).stock(25).category(toys).build(),
                    Product.builder().name("Osito de peluche gigante").description("Oso de felpa marrón 1.5m").price(280.00).stock(18).category(toys).build(),
                    Product.builder().name("Drone DJI Mini").description("Drone con cámara 4K").price(2500.00).stock(6).category(toys).build(),
                    Product.builder().name("Set Play-Doh colores").description("10 frascos de masa moldeable").price(120.00).stock(40).category(toys).build(),
                    Product.builder().name("Transformers Optimus Prime").description("Figura articulada de colección").price(400.00).stock(14).category(toys).build(),
                    Product.builder().name("Nintendo Switch Lite").description("Consola portátil color turquesa").price(1300.00).stock(10).category(toys).build(),

                    // Libros
                    Product.builder().name("Cien años de soledad").description("Gabriel García Márquez").price(80.00).stock(50).category(books).build(),
                    Product.builder().name("El principito").description("Antoine de Saint-Exupéry").price(50.00).stock(60).category(books).build(),
                    Product.builder().name("Harry Potter y la piedra filosofal").description("J.K. Rowling").price(95.00).stock(40).category(books).build(),
                    Product.builder().name("El señor de los anillos").description("J.R.R. Tolkien").price(120.00).stock(35).category(books).build(),
                    Product.builder().name("Don Quijote de la Mancha").description("Miguel de Cervantes").price(110.00).stock(25).category(books).build(),
                    Product.builder().name("1984").description("George Orwell").price(75.00).stock(45).category(books).build(),
                    Product.builder().name("Sapiens: De animales a dioses").description("Yuval Noah Harari").price(140.00).stock(20).category(books).build(),
                    Product.builder().name("It").description("Stephen King").price(130.00).stock(18).category(books).build(),
                    Product.builder().name("Orgullo y prejuicio").description("Jane Austen").price(90.00).stock(30).category(books).build(),
                    Product.builder().name("Crónica de una muerte anunciada").description("Gabriel García Márquez").price(70.00).stock(28).category(books).build()
            );

            productRepository.saveAll(products);
            log.info("PRODUCTS AND CATEGORIES IS INGRESS");
        }
    }
}