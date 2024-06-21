// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

// Function to generate random data
function generateRandomData(length, min, max) {
  return Array.from({ length: length }, () => Math.floor(Math.random() * (max - min + 1)) + min);
}

// Data for the store bar charts
var storeLabels = ["찬흠가구", "영민가구", "예림가구", "선정가구", "짱구가구", "철수가구", "유리가구", "훈이가구", "맹구가구", "수지가구"];
var monthLabels = ["6월", "7월", "8월", "9월", "10월", "11월", "12월", "1월", "2월", "3월", "4월", "5월"];
var minSales = 30000000;
var maxSales = 100000000;

// Function to create a bar chart
function createBarChart(ctx, labels, label, data) {
  return new Chart(ctx, {
    type: 'bar',
    data: {
      labels: labels,
      datasets: [{
        label: label,
        backgroundColor: "rgba(2,117,216,1)",
        borderColor: "rgba(2,117,216,1)",
        data: data,
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
            maxTicksLimit: labels.length
          }
        }],
        yAxes: [{
          ticks: {
            min: 0,
            max: maxSales,
            maxTicksLimit: 12
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
}

// Create the main store bar chart
var ctx = document.getElementById("storeBarChart");
createBarChart(ctx, storeLabels, "지난달 판매금액", generateRandomData(storeLabels.length, minSales, maxSales));

// Create individual store bar charts
for (var i = 1; i <= 10; i++) {
  var ctxStore = document.getElementById(`store${i.toString().padStart(2, '0')}BarChart`);
  createBarChart(ctxStore, monthLabels, "월별 판매금액", generateRandomData(monthLabels.length, minSales, maxSales));
}