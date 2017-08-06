# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
#encoding: utf8

require_relative "Treasure"
require_relative "BadConsequence"
require_relative "TreasureKind"

module NapakalakiGame
  


class BadConsequence
  
   attr_reader :text, :levels, :nVisible, :nHidden, :specificVisibleTreasures, :specificHiddenTreasures, :death
  
  def initialize(aText, someLevels, someVisibleTreasures,
      someHiddenTreasures, someSpecificVisibleTreasures,
      someSpecificHiddenTreasures, death)
    
    @text = aText
    @levels = someLevels
    @nVisible = someVisibleTreasures
    @nHidden = someHiddenTreasures
    @specificVisibleTreasures = someSpecificVisibleTreasures
    @specificHiddenTreasures = someSpecificHiddenTreasures
    @death = death
  end
  
  
   def self.newLevelNumberOfTreasures (aText, someLevels,
    someVisibleTreasures, someHiddenTreasures)  
    	# asigna memoria para el objeto
      nuevoObj=allocate      
      # inicializa el objeto, invocando al método initialize
      nuevoObj.send(:initialize,aText,someLevels,someVisibleTreasures,someHiddenTreasures,Array.new,Array.new,false)     
      #devuelve el objeto creado e inicializado
      nuevoObj 
  end
   
   def self.newLevelSpecificTreasures (aText, someLevels, someSpecificVisibleTreasures, someSpecificHiddenTreasures)
    
    	# asigna memoria para el objeto
      nuevoObj=allocate      
      # inicializa el objeto, invocando al método initialize
      nuevoObj.send(:initialize,aText,someLevels,0,0,someSpecificVisibleTreasures,someSpecificHiddenTreasures,false)     
      #devuelve el objeto creado e inicializado
      nuevoObj 
  end
 
  def self.newDeath (aText)
    	# asigna memoria para el objeto
      nuevoObj=allocate      
      # inicializa el objeto, invocando al método initialize
      nuevoObj.send(:initialize,aText,0,0,0,Array.new,Array.new,true)     
      #devuelve el objeto creado e inicializado
      nuevoObj 
  end   
   
  private_class_method :new  #NO es accesible desde fuera de la clase
  
  #Devuelve true cuando el mal rollo que tiene que cumplir el jugador está vacío
  def isEmpty
      vacio=false;
      if ((@levels+ @nVisible+ @nHidden) == 0 && @death==false && @specificHiddenTreasures.empty? && @specificVisibleTreasures.empty?)
         vacio=true;
      end
      return vacio
  end
  

  
#   Actualiza el mal rollo que tiene que cumplir el jugador, en función del tipo de tesoro de t y
#   del tipo de mal rollo que tenga que cumplir el jugador.

  def substractVisibleTreasure(t)   #Treasure t
    
    if (!@specificVisibleTreasures.empty?)
      @specificVisibleTreasures.each { |a|  
        if (a == t.type)
          @specificVisibleTreasures.delete(a)
        end
       }
    else
      @nVisible = @nVisible - 1
    end
  end
  
  # //Igual que el anterior pero para los Ocultos.
  def substractHiddenTreasure(t)    #Treasure t
    
   if (! @specificHiddenTreasures.empty?) 
     @specificHiddenTreasures.each { |a|  
      if (a == t.type)
        @specificHiddenTreasures.delete(a)
      end
    }
   else
      @nHidden =  @nHidden - 1
   end   
  end
  
# Recibe como parámetros los tesoros visibles y ocultos de los que dispone el jugador y
#devuelve un nuevo objeto mal rollo que contiene una lista de tipos tesoros visibles y
#ocultos de los que el jugador debe deshacerse. El objeto de mal rollo devuelto por
#adjustToFitTreasureList solo contendrá tipos de tesoros y en una cantidad
#adecuada a los que el jugador puede llegar a deshacerse en función de los que dispone.
  def adjustToFilTreasureLists(v, h)    #Array <Treasure>
    if (@death)
      bc = BadConsequence.newDeath(@text, @death)
    elsif (@specificHiddenTreasures.empty? && @specificVisibleTreasures.empty?)
                nTesorosVisibles=v.size
                nTesorosOcultos=h.size
                minVisible = (nTesorosVisibles < @nVisibleTreasures) ? nTesorosVisibles : @nVisibleTreasures 
                minOculto = (nTesorosOcultos < @nHiddenTreasures) ? nTesorosOcultos : @nHiddenTreasures
                bc = BadConsequence.newLevelNumberOfTreasures(@text, 0, minVisible, minOculto)     
      else
        visibles=Array.new
        ocultos=Array.new
        tipos=Array.new
        
        tipos << TreasureKind::ARMOR 
        tipos << TreasureKind::ONEHAND 
        tipos << TreasureKind::BOTHHAND 
        tipos << TreasureKind::HELMET 
        tipos << TreasureKind::SHOE 
        tipos << TreasureKind::NECKLACE
        
        tipos.each { 
          |tesoro|  
          #         Visibles
      
          contVisible =   @specificVisibleTreasures.count(tesoro)  
          cont = v.count(tesoro)
          
        
          minimo = (cont < contVisible) ? cont : contVisible
          for i in 1..minimo
            visibles << tesoro
          end
          
          #         Ocultos
          contOculto =   @specificHiddenTreasures.count(tesoro)
         
           cont = h.count(tesoro)
       
        minimo = (cont < contOculto) ? cont : contOculto
        
        for i in 1..minimo
          ocultos << tesoro
        end
       }
        
       bc = BadConsequence.newLevelSpecificTreasures(@text, 0, visibles, ocultos)
    end
    
    return bc
    
  end
  
  #Devuelve true si es un mal rollo es muerte, false en caso contrario.
  def myBadConsequeselsDeath
     @death
  end
  
  #Metodo to String
 def to_s    
    cadena = " \n\t\tText = #{@text} \n\t\tLevel = #{@levels} \n\t\tSomeVisibleTreasures = #{@nVisible} \n\t\tSomeHiddenTreasures = #{@nHidden} \n\t\tDeath = #{@death}"
    specificVisibleTreasures.each { |t| cadena +=  " \n\t\tSomeSpecificVisibleTreasures = #{t}"  }
    specificHiddenTreasures.each { |t| cadena +=  " \n\t\tSomeSpecificHiddenTreasures = #{t}"  }
    return cadena
  end 
  
 end

end