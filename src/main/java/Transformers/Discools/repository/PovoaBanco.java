package Transformers.Discools.repository;

import Transformers.Discools.model.CategoriaDisco;
import Transformers.Discools.model.DiscosCD;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;


@Component
public class PovoaBanco {

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
        carregarDadosIniciais();
    }

    // ===================== DADOS INICIAIS =====================
    private void carregarDadosIniciais() {

        // Criação de todos os produtos do sistema
        DiscosCD disco1 = new DiscosCD(0, "Meus Caros Amigos", "Chico Buarque", "Bossa - Nova", 45, 96.80f,
                "Uma obra marcante da fase madura de Chico Buarque, unindo crítica social, lirismo e arranjos sofisticados. As canções trazem um olhar atento sobre o Brasil, equilibrando leveza melódica e profundidade temática, tornando o álbum atemporal.",
                2, "Disco", "/midia/capas/Capa1.jpeg");
        discoRepository.save(disco1);

        DiscosCD disco2 = new DiscosCD(0, "I`ve Tried Everything but Therapy", "Teddy Swims", "Alternativa", 45, 96.90f,
                "Um álbum que mistura soul, pop e R&B, explorando vulnerabilidade emocional e autoconhecimento. Teddy Swims entrega vocais intensos e letras marcantes sobre relações difíceis e processos de cura interna.",
                5, "Disco", "/midia/capas/Capa2.png");
        discoRepository.save(disco2);

        DiscosCD disco3 = new DiscosCD(0, "Mucho Barato", "Control Machete", "Hip Hop", 45, 119.99f,
                "Um dos discos mais importantes do hip hop latino, trazendo batidas pesadas e letras diretas. A energia crua e o estilo agressivo do grupo consolidaram este álbum como referência do gênero nos anos 90.",
                3, "Disco", "/midia/capas/Capa3.jpg");
        discoRepository.save(disco3);

        DiscosCD disco4 = new DiscosCD(0, "Hollow Knight (Original Soundtrack)", "Christopher Larkin", "Orquestra", 45, 220.00f,
                "Uma trilha sonora atmosférica que une orquestração delicada e tons melancólicos. As composições constroem um mundo imersivo, capturando perfeitamente a sensação de mistério, solidão e beleza do jogo.",
                1, "Disco", "/midia/capas/Capa4.jpg");
        discoRepository.save(disco4);

        DiscosCD disco5 = new DiscosCD(0, "Sobrevivendo no Inferno", "Racionais MC's", "Rap", 45, 78.90f,
                "Um marco absoluto do rap brasileiro, com letras contundentes sobre desigualdade, violência e resistência. O álbum combina narrativa forte, crítica social e produção icônica, tornando-se parte da história da música nacional.",
                4, "Disco", "/midia/capas/Capa5.jpg");
        discoRepository.save(disco5);

        DiscosCD disco6 = new DiscosCD(0, "The Normal Album", "Will Wood", "Pop Rock", 45, 119.90f,
                "Um álbum excêntrico, criativo e emocionalmente complexo. Will Wood mistura teatralidade, humor irônico e reflexões profundas sobre identidade e saúde mental, entregando uma experiência musical singular.",
                3, "Disco", "/midia/capas/Capa6.jpg");
        discoRepository.save(disco6);

        DiscosCD disco7 = new DiscosCD(0, "Addison", "Addison Rae", "Pop", 45, 302.00f,
                "Um projeto pop moderno que combina produção elegante, melodias cativantes e estética atual. O álbum mostra uma proposta sonora envolvente, explorando temas como confiança, imagem e emoções jovens.",
                5, "Disco", "/midia/capas/Capa7.jpg");
        discoRepository.save(disco7);

        DiscosCD disco8 = new DiscosCD(0, "Folklore", "Taylor Swift", "Indie/pop", 45, 74.90f,
                "Um dos trabalhos mais refinados de Taylor Swift, com composições introspectivas, atmosfera tranquila e narrativa madura. O álbum explora histórias, sentimentos e metáforas em uma sonoridade leve e melódica.",
                5, "CD", "/midia/capas/Capa8.png");
        discoRepository.save(disco8);

        DiscosCD disco9 = new DiscosCD(0, "Lux", "Rosalía", "Pop", 45, 79.90f,
                "Um álbum que mistura experimentação pop, estética moderna e o estilo vocal marcante de Rosalía. As faixas exploram intensidade emocional e identidade artística, criando um trabalho coeso e impactante.",
                5, "CD", "/midia/capas/Capa9.jpeg");
        discoRepository.save(disco9);

        DiscosCD disco10 = new DiscosCD(0, "Hozier", "Hozier", "Folk", 45, 130.00f,
                "O álbum de estreia de Hozier combina folk, soul e poesia sombria. Com vocais profundos e letras carregadas de simbolismo, o disco aborda temas como humanidade, fé e amor com forte expressão emocional.",
                5, "Disco", "/midia/capas/Capa10.jpg");
        discoRepository.save(disco10);

        DiscosCD disco11 = new DiscosCD(0, "Alumbramento", "Djavan", "MPB", 45, 80.00f,
                "Um clássico da MPB com harmonias ricas, melodias fluidas e o estilo inconfundível de Djavan. O álbum combina romantismo, poesia e ritmos brasileiros em composições vibrantes e sofisticadas.",
                5, "Disco", "/midia/capas/Capa11.jpeg");
        discoRepository.save(disco11);

        DiscosCD disco12 = new DiscosCD(0, "From Zero", "Linkin Park", "Rock", 45, 150.00f,
                "Um álbum que revisita elementos marcantes do rock alternativo com emoção e intensidade. As faixas exploram resiliência, perda e reconexão, trazendo a identidade sonora característica do Linkin Park.",
                5, "Disco", "/midia/capas/Capa12.jpg");
        discoRepository.save(disco12);



        // ========== CATEGORIAS DA HOME ==========
        categoriaDiscoRepository.save(new CategoriaDisco(0, "Em alta", new ArrayList<>(List.of(disco1, disco2, disco3, disco4))));
        categoriaDiscoRepository.save(new CategoriaDisco(0, "Lançamentos", new ArrayList<>(List.of(disco5, disco6, disco7, disco8))));
        categoriaDiscoRepository.save(new CategoriaDisco(0, "Recomendados", new ArrayList<>(List.of(disco9, disco10, disco11, disco12))));
    }

}
