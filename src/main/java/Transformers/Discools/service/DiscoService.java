package Transformers.Discools.service;

import org.springframework.stereotype.Service;
import Transformers.Discools.repository.CategoriaDiscoRepository;
import Transformers.Discools.repository.DiscoRepository;
import Transformers.Discools.model.CategoriaDisco;
import Transformers.Discools.model.DiscosCD;

@Service
public class DiscoService {

    private final CategoriaDiscoRepository categoriaDiscoRepository;
    private final DiscoRepository discoRepository;

    public DiscoService(CategoriaDiscoRepository categoriaDiscoRepository, DiscoRepository discoRepository) {
        this.categoriaDiscoRepository = categoriaDiscoRepository;
        this.discoRepository = discoRepository;
    }

    public CategoriaDisco listarPorCategoria(int categoriaId) {
        return categoriaDiscoRepository.findById(categoriaId).orElse(null);
    }

    public DiscosCD buscarPorId(int id) {
        return discoRepository.findById(id).orElse(null);
    }
}
