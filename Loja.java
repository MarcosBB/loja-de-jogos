import java.util.List;
import java.util.ArrayList;

public class Loja extends Empresa {
    public List<Jogo> jogosDisponiveis;

    public Loja(String nome) {
        super(nome);
        jogosDisponiveis = new ArrayList<Jogo>();
    }

    public boolean AdicionarJogo(Jogo jogo) {
        if (!jogosDisponiveis.contains(jogo)) {
            return true;
        } else {
            return false;
        }
    }

    public List<Jogo> Busca(Jogo.Genero genero) {
        List<Jogo> jogosFiltrados = new ArrayList<Jogo>();
        for (Jogo jogo : jogosDisponiveis) {
            if (jogo.getGenero() == genero) {
                jogosFiltrados.add(jogo);
            }
        }
        return jogosFiltrados;
    }

    public List<Jogo> Busca(Jogo.Plataforma plataforma) {
        List<Jogo> jogosFiltrados = new ArrayList<Jogo>();
        for (Jogo jogo : jogosDisponiveis) {
            if (jogo.getPlataforma() == plataforma) {
                jogosFiltrados.add(jogo);
            }
        }
        return jogosFiltrados;
    }

    public List<Jogo> Busca(float preco) {
        List<Jogo> jogosFiltrados = new ArrayList<Jogo>();
        for (Jogo jogo : jogosDisponiveis) {
            if (jogo.getPreco() <= preco) {
                jogosFiltrados.add(jogo);
            }
        }
        return jogosFiltrados;
    }

    public void adicionarCarrinho(Usuario usuario, Jogo jogo) {
        if (jogosDisponiveis.contains(jogo)) {
            List<Jogo> carrinhoAtual = usuario.getCarrinho();
            carrinhoAtual.add(jogo);
            usuario.setCarrinho(carrinhoAtual);
        }
    }

    public void compraRealizada(Usuario usuario) {
        List<Jogo> carrinhoAtual = usuario.getCarrinho();
        for (Jogo jogo : carrinhoAtual) {
            jogo.iterarCopiasVendidas();
            this.recebeDinheiro(jogo.getPreco() * 4 / 5);
            // FUNCAO GETPRODUTORA NAO EXISTE TEM QUE IMPLEMENTAR
            jogo.getProdutora().recebeDinheiro(jogo.getPreco() * 1 / 5);
        }
    }
}