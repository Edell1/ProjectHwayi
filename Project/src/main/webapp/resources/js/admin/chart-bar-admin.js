// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

// Bar Chart Example
var ctx = document.getElementById("storeBarChart");
var myLineChart = new Chart(ctx, {
  type: 'bar',
  data: {
    labels: ["찬흠가구", "영민가구", "예림가구", "선정가구", "짱구가구", "철수가구", "유리가구", "훈이가구", "맹구가구", "수지가구"],
    datasets: [{
      label: "지난달 판매금액",
      backgroundColor: "rgba(2,117,216,1)",
      borderColor: "rgba(2,117,216,1)",
      data: [72150000, 93120000, 62510000, 47841000, 51980000, 49841000, 61498000, 56300000, 34910000, 41498000],
    }],
  },
  options: {
    scales: {
      xAxes: [{
        time: {
          unit: 'month'
        },
        gridLines: {
          display: false
        },
        ticks: {
          maxTicksLimit: 10
        }
      }],
      yAxes: [{
        ticks: {
          min: 0,
          max: 100000000,
          maxTicksLimit: 10
        },
        gridLines: {
          display: true
        }
      }],
    },
    legend: {
      display: false
    }
  }
});

document.getElementById("storeBarChart").onclick = function(evt) {
        var activePoints = storeBarChart.getElementsAtEvent(evt);

        if(activePoints.length > 0)
        {
            var clickedElementindex = activePoints[0]["_index"];

            var label = storeBarChart.data.labels[clickedElementindex];
            console.log("label : " + label);
            System.out.println("ㅁㅁㅁ");

            var value = storeBarChart.data.datasets[0].data[clickedElementindex];
            console.log("value : " + value);
        }
    }
