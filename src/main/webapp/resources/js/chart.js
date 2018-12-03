var s=document.getElementById('solucionado').value ;
var r=document.getElementById('espera').value ;
var e=document.getElementById('revision').value ;
var d=document.getElementById('desechado').value ;
var p=document.getElementById('proyecto').value ;
var areaD=document.getElementById('areaD').value ;
var areaP=document.getElementById('areaP').value ;
var canvasArea = document.getElementById("AreapolarChart").getContext('2d');
var ctxPA = document.getElementById("polarChart").getContext('2d');
  var myPolarChart = new Chart(ctxPA, {
   
    type: 'polarArea',
    data: {
      labels: ["Revision", "Espera", "Solucionado", "Desechado", "Proyecto"],
      datasets: [{
        data: [r, e, s, d, p],
        backgroundColor: ["rgba(219, 0, 0, 0.1)", "rgba(0, 165, 2, 0.1)", "rgba(255, 195, 15, 0.2)",
          "rgba(55, 59, 66, 0.1)", "rgba(0, 0, 0, 0.3)"
        ],
        hoverBackgroundColor: ["rgba(219, 0, 0, 0.2)", "rgba(0, 165, 2, 0.2)",
          "rgba(255, 195, 15, 0.3)", "rgba(55, 59, 66, 0.1)", "rgba(0, 0, 0, 0.4)"
        ]
      }]
    },
    options: {
      responsive: true
    }
  });
  
    var chartArea = new Chart(canvasArea, {
   
    type: 'polarArea',
    data: {
      labels: ["PMO", "Decanatura Sistemas"],
      datasets: [{
        data: [areaD, areaP],
        backgroundColor: ["rgba(219, 0, 0, 0.1)", "rgba(0, 165, 2, 0.1)"],
        hoverBackgroundColor: ["rgba(219, 0, 0, 0.2)", "rgba(0, 165, 2, 0.2)"]
      }]
    },
    options: {
      responsive: true
    }
  });


