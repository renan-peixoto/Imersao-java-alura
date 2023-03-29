import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoIMDB implements ExtratorDeConteudo {

  @Override
  public List<Conteudo> extrairConteudos(String json) {
    // extrair só os dados que interessam (titulo, poster, classificação)
    JsonParser parser = new JsonParser();
    List<Map<String, String>> listaDeAtributos = parser.parse(json);

    List<Conteudo> conteudos = new ArrayList<>();

    for (Map<String, String> atributos : listaDeAtributos) {
      String titulo = atributos.get("title");
      String urlImage = atributos.get("image");

      Conteudo conteudo = new Conteudo(titulo, urlImage);

      conteudos.add(conteudo);
    }

    return conteudos;
  }
}