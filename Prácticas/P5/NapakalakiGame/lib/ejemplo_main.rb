# encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "Napakalaki"
require_relative "game_tester"

module Test

  class EjemploMain
   
      def prueba
        
       test = GameTester.instance
     
        game = NapakalakiGame::Napakalaki.instance
   
       #Se prueba el juego con 2 jugadores
   
       test.play(game, 2);
       
      end
      
  end
  
    e = EjemploMain.new
    e.prueba()

end
