package Transformers.Discools.repository;

import Transformers.Discools.model.CategoriaDisco;
import Transformers.Discools.model.DiscosCD;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;


@Component
public class PovoaBanco {

    private static final int ID_AINDA_NAO_GERADO = 0;
    private static final int DURACAO_PADRAO_EM_MINUTOS = 45;

    private final DiscoRepository discoRepository;
    private final CategoriaDiscoRepository categoriaDiscoRepository;

    public PovoaBanco(DiscoRepository discoRepository, CategoriaDiscoRepository categoriaDiscoRepository) {
        this.discoRepository = discoRepository;
        this.categoriaDiscoRepository = categoriaDiscoRepository;
    }

    @PostConstruct
    public void init() {
        if (discoRepository.count() > 0) {
            return;
        }
        List<DiscosCD> discos = gravarDiscos();
        gravarCategorias(discos);
    }

    // ===================== DADOS INICIAIS =====================
    private List<DiscosCD> gravarDiscos() {
        List<DiscosCD> discos = List.of(
                disco("Meus Caros Amigos", "Chico Buarque", "Bossa - Nova", 96.80f,
                        "Uma obra marcante da fase madura de Chico Buarque, unindo crítica social, lirismo e arranjos sofisticados. As canções trazem um olhar atento sobre o Brasil, equilibrando leveza melódica e profundidade temática, tornando o álbum atemporal.",
                        2, "Disco", "/midia/capas/Capa1.jpeg"),
                disco("I`ve Tried Everything but Therapy", "Teddy Swims", "Alternativa", 96.90f,
                        "Um álbum que mistura soul, pop e R&B, explorando vulnerabilidade emocional e autoconhecimento. Teddy Swims entrega vocais intensos e letras marcantes sobre relações difíceis e processos de cura interna.",
                        5, "Disco", "/midia/capas/Capa2.png"),
                disco("Mucho Barato", "Control Machete", "Hip Hop", 119.99f,
                        "Um dos discos mais importantes do hip hop latino, trazendo batidas pesadas e letras diretas. A energia crua e o estilo agressivo do grupo consolidaram este álbum como referência do gênero nos anos 90.",
                        3, "Disco", "/midia/capas/Capa3.jpg"),
                disco("Hollow Knight (Original Soundtrack)", "Christopher Larkin", "Orquestra", 220.00f,
                        "Uma trilha sonora atmosférica que une orquestração delicada e tons melancólicos. As composições constroem um mundo imersivo, capturando perfeitamente a sensação de mistério, solidão e beleza do jogo.",
                        1, "Disco", "/midia/capas/Capa4.jpg"),
                disco("Sobrevivendo no Inferno", "Racionais MC's", "Rap", 78.90f,
                        "Um marco absoluto do rap brasileiro, com letras contundentes sobre desigualdade, violência e resistência. O álbum combina narrativa forte, crítica social e produção icônica, tornando-se parte da história da música nacional.",
                        4, "Disco", "/midia/capas/Capa5.jpg"),
                disco("The Normal Album", "Will Wood", "Pop Rock", 119.90f,
                        "Um álbum excêntrico, criativo e emocionalmente complexo. Will Wood mistura teatralidade, humor irônico e reflexões profundas sobre identidade e saúde mental, entregando uma experiência musical singular.",
                        3, "Disco", "/midia/capas/Capa6.jpg"),
                disco("Addison", "Addison Rae", "Pop", 302.00f,
                        "Um projeto pop moderno que combina produção elegante, melodias cativantes e estética atual. O álbum mostra uma proposta sonora envolvente, explorando temas como confiança, imagem e emoções jovens.",
                        5, "Disco", "/midia/capas/Capa7.jpg"),
                disco("Folklore", "Taylor Swift", "Indie/pop", 74.90f,
                        "Um dos trabalhos mais refinados de Taylor Swift, com composições introspectivas, atmosfera tranquila e narrativa madura. O álbum explora histórias, sentimentos e metáforas em uma sonoridade leve e melódica.",
                        5, "CD", "/midia/capas/Capa8.png"),
                disco("Lux", "Rosalía", "Pop", 79.90f,
                        "Um álbum que mistura experimentação pop, estética moderna e o estilo vocal marcante de Rosalía. As faixas exploram intensidade emocional e identidade artística, criando um trabalho coeso e impactante.",
                        5, "CD", "/midia/capas/Capa9.jpeg"),
                disco("Hozier", "Hozier", "Folk", 130.00f,
                        "O álbum de estreia de Hozier combina folk, soul e poesia sombria. Com vocais profundos e letras carregadas de simbolismo, o disco aborda temas como humanidade, fé e amor com forte expressão emocional.",
                        5, "Disco", "/midia/capas/Capa10.jpg"),
                disco("Alumbramento", "Djavan", "MPB", 80.00f,
                        "Um clássico da MPB com harmonias ricas, melodias fluidas e o estilo inconfundível de Djavan. O álbum combina romantismo, poesia e ritmos brasileiros em composições vibrantes e sofisticadas.",
                        5, "Disco", "/midia/capas/Capa11.jpeg"),
                disco("From Zero", "Linkin Park", "Rock", 150.00f,
                        "Um álbum que revisita elementos marcantes do rock alternativo com emoção e intensidade. As faixas exploram resiliência, perda e reconexão, trazendo a identidade sonora característica do Linkin Park.",
                        5, "Disco", "/midia/capas/Capa12.jpg")
        );
        return discoRepository.saveAll(discos);
    }

    private DiscosCD disco(String nome, String artista, String genero, float preco, String descricao, int estoque, String tipo, String capa) {
        return new DiscosCD(ID_AINDA_NAO_GERADO, nome, artista, genero, DURACAO_PADRAO_EM_MINUTOS, preco, descricao, estoque, tipo, capa);
    }

    private void gravarCategorias(List<DiscosCD> discos) {
        categoriaDiscoRepository.save(new CategoriaDisco(ID_AINDA_NAO_GERADO, "Em alta", new ArrayList<>(List.of(discos.get(0), discos.get(1), discos.get(2), discos.get(3)))));
        categoriaDiscoRepository.save(new CategoriaDisco(ID_AINDA_NAO_GERADO, "Lançamentos", new ArrayList<>(List.of(discos.get(4), discos.get(5), discos.get(6), discos.get(7)))));
        categoriaDiscoRepository.save(new CategoriaDisco(ID_AINDA_NAO_GERADO, "Recomendados", new ArrayList<>(List.of(discos.get(8), discos.get(9), discos.get(10), discos.get(11)))));
    }

}
