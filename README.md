# Banco_De_Ideas

´´´ HTML
<div class="modal fade" id="ModalVotoMias" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content"></div>
            </div>
            <div class="modal-dialog">
                <div class="modal-content"></div>
            </div>
            <div class="modal-dialog">

                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"> <span aria-hidden="true" class=""></span><span class="sr-only">Close</span>
                        </button>
                         
                        <h4 class="modal-title glyphicon glyphicon-pushpin" id="myModalLabel"> Votar</h4>

                    </div>
                    <div class="modal-body">
                        <h:form id="votosMias_form">
                            <input type="text" name="lik" id="lik" value="" style="visibility: hidden"/>
                            <p:inputText id="lik" binding="#{lik}" type="hidden"/>
                            
                            <div class="form-group" >
                                <h:panelGroup  style="position: center" id="prueba">
                                    
                                    
                                	<p:commandButton styleClass="oculto" style="display:none"
                                         actionListener="#{iniciativaBean.votar(lik.value)}" value="">                                                                                      
                                    </p:commandButton>
                                     
                                    <p:commandButton styleClass="mia btn btn-default glyphicon glyphicon-hand-right"    
                                         value="">                                             
                                    </p:commandButton>
                                    <p:commandButton   
                                         update="comentariosMiaPanel" value="Cargar comentarios"  styleClass="btn btn-default glyphicon glyphicon-folder-open" 
                                         style="background-color: rgba(144, 22, 38, 0.7);
                                             
                                             text-align:center; 
                                             display: inline-block;
                                             left:15%;
                                             border-radius: 11px;                              
                                             color : rgba(255, 255, 255, 1)">                             
                                    </p:commandButton>
                                   
                                    <p></p>
                                    <h:panelGroup id="comentariosMiaPanel">
                                        <table id="comentarios" class="table table-striped table-bordered"
                                            style="width: 100%">
                                            <thead>
                                                <tr>
                                                    <th>Nombre</th>
                                                    <th>Comentarios</th>
                                                    <th>Fechas</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <ui:repeat value="#{iniciativaBean.getComentarios(lik.value)}" var="com">
                                                    <tr>
                                                        <td>#{com.autor.nombre}</td>
                                                        <td>#{com.contenido}</td>
                                                        <td>#{com.fecha}</td>
                                                    </tr>
                                                </ui:repeat>
                                                </tbody>
                                        </table>
                                        <h:outputScript name="dataTable/js/jquery.dataTables.min.js" />
                                         <h:outputScript name="dataTable/js/dataTables.bootstrap.min.js" />
                        <h:outputScript name="js/tableRefresh.js" />
                                    </h:panelGroup>
                                    <div class="panel panel-default" style="border-radius: 11px;">
                                    <div class="panel-heading" style="  color: white;
												background-color: #8b0000!important;
												border-color: #8b0000!important;
												border-radius: 11px;
                                            ">Agregar Comentario</div>
                                      <div class="panel-body">
                                        <form>
                                            <div class="form-group contact-form php-mail-form" >
                                                <p:inputTextarea rows="6" cols="33" id="mt" class="form-control"
                                                binding="#{comentarioTexto}" placeholder="Agrega un comentario"
                                                style="color:black; border-radius: 11px;
                                                    background-color: rgba(255, 237, 246, 0.3);
                                                    border: rgba(255, 237, 246, 0.3);
                                                    border-color: rgba(144, 22, 38, 0.7);
                                                    width:100%"/>
                                                <p></p>
                                            </div>
                                        </form>
                                     </div>
                                        <div class="panel-footer" style="background-color: transparent;">
                                         <div class="loading"></div>
            
                                        <p:commandButton class="form-send" value="Comentar" styleClass="btn btn-default glyphicon glyphicon-pencil" 
                                       style="
                                                 background-color:#8b0000!important;
                                                 border: rgba(144, 22, 38, 0.7);
                                                 text-align:center;                                 
                                                 color : rgba(255, 255, 255, 1)
                                                 "
                                        actionListener="#{iniciativaBean.registrarComentario(comentarioTexto.value,lik.value)}">
                                    </p:commandButton>
                                     </div>
                                    </div>

                    
                                </h:panelGroup>
                            </div>
                            <div class="modal-footer">
                                <button id="cancelar" type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                            </div>
                        </h:form>
                    </div>

                </div>
            </div>
        </div>

´´´

# Usuario

## Consultar la información relacianada con las ideas o iniciativas que tienen un estado determinado
	* Hacer filto por el estado
	* Hacer la busqueda por la palabra clave
	
	

## Ver estadísticas de las iniciativas registradas en el sistema
	* Las estadisticas  se tienen que dar por medio del estado que tenga cada iniciativas
	* La informacion de la estadistica se tiene que mostrar visible en un reporte ese decir un File
	* Hacer un diagrama de barras o torta seria lo mas factible
		Al hacer el diagrama de torta  deberia dar la facilidad saber de que es el diagrama y cual esta agrupando
## Consultar todas las ideas o iniciativas
	La consulta debe estar paginada
	La consulta se debe poder ordenar por cualquiera de las columnas de la información

	
## Poder votar por alguna iniciativa o idea que me parezca interesante
	El sistema debe permitir agreagar comentarios a las iniciativas registradas
	El sistema debe guardar la información del interesado
	El sistema debe guardar la fecha de creación del comentario

	
# Publico
## 	Poder mostrar mi interes y dejar comentarios a una iniciativa o idea que me parezca interesante
			El sistema debe permitir agreagar comentarios a las iniciativas registradas
			El sistema debe guardar la información del interesado
			El sistema debe guardar la fecha de creación del comentario
			


	
# Proponente
## Poder modificar la información de una propuesta presentadas
	Solo se puede cambiar las que esten "en espera de revisión".
## Registrar la información de mi idea o iniciativa de proyecto
	El registro debe tener la descripción de la idea o inicitiva
	El registro debe tener la fecha en la que se realizó
	El registro debe tener la información del proponente
	El registro debe tener las palabras clave de la idea o iniciativa
	El registro debe el area o dependencia a la que pertenece el proponente
			
# Administrador
## 	Cambiar el estado de un usuario
		Debe existir un filtro al buscar los usuarios
## 	Al cambiar el usuario  el estado debe tener el listado de las posibles opciones a cambiar
		El cambio de estado debe seleccionarse de una lista de estados posibles.
	
	
