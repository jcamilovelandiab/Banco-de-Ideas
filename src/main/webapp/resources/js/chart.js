  var ctxPA = document.getElementById("polarChart").getContext('2d');
  var myPolarChart = new Chart(ctxPA, {
     
    type: 'polarArea',
    data: {
      labels: ["Revision", "Espera", "Solucionado", "Desechado", "Proyecto"],
      datasets: [{
        data: [100, 50, 100, 40, 120],
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


