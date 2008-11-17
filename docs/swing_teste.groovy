import groovy.swing.SwingBuilder
import javax.swing.WindowConstants as WC
import javax.swing.JOptionPane

swing = new SwingBuilder()
about = swing.action(name: 'About', closure: this.&showAbout, mnemonic: 'A', accelerator: 'F1')
frame = swing.frame(title:'Demo',defaultCloseOperation:WC.EXIT_ON_CLOSE) {
  menuBar {
    menu('File') {
      menuItem 'New'
      menuItem 'Open'
    }
    glue()
    menu('Help') {
      menuItem('About',action:about)
    }
  }
  panel {
    label 'Label 1'
    slider()
    comboBox(items:['one','two','three'])
  }
}

def showAbout(event) {
  JOptionPane.showMessageDialog(frame,'Teste')
}
frame.pack()
frame.show()
