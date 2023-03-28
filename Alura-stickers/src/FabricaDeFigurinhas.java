import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class FabricaDeFigurinhas {

  public void criar() throws Exception {
    // leitura da imagem
    BufferedImage original = ImageIO.read(
      new File("Alura-stickers/entrada/filme.jpg")
    );
    // criar nova imagem em memória com transparência e com tamanho novo

    int largura = original.getWidth();
    int altura = original.getHeight();
    int novaAltura = altura + 200;

    BufferedImage novaImagem = new BufferedImage(
      largura,
      novaAltura,
      BufferedImage.TRANSLUCENT
    );
    // copiar a nova imagem para nova imagem (em memória)

    Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
    graphics.drawImage(original, 0, 0, null);

    // configurar fonte

    Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
    graphics.setFont(fonte);
    graphics.setColor(Color.YELLOW);

    // escrever uma frase na nova imagem

    graphics.drawString("ShawShank", 100, novaAltura - 100);

    // escrever a nova imagem em um arquivo
    ImageIO.write(
      novaImagem,
      "png",
      new File("Alura-stickers/saida/figurinha.png")
    );
  }

  public static void main(String[] args) throws Exception {
    var geradora = new FabricaDeFigurinhas();
    geradora.criar();
  }
}