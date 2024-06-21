// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

// Function to generate random data
function generateRandomData(length, min, max) {
  return Array.from({ length: length }, () => (Math.random() * (max - min) + min).toFixed(2));
}

// Labels and color for pie charts
var pieLabels = ["침대", "소파", "파티션", "거울", "서랍장", "선반", "행거/옷장", "거실장/TV장", "책장", "의자", "책상"];
var backgroundColors = ['#FF0000', '#D0FA58', '#9F81F7', '#08088A', '#18a745', '#B40486', '#FFFF00', '#2EFEF7', '#FF8000', '#A9F5A9', '#0174DF'];

// Function to create a pie chart
function createPieChart(ctx, labels, data, backgroundColors) {
  return new Chart(ctx, {
    type: 'pie',
    data: {
      labels: labels,
      datasets: [{
        data: data,
        backgroundColor: backgroundColors,
      }],
    },
  });
}

// Create the main furniture pie chart
var ctx = document.getElementById("furniturePieChart");
createPieChart(ctx, pieLabels, generateRandomData(pieLabels.length, 1, 15), backgroundColors);

// Create individual store pie charts
for (var i = 1; i <= 10; i++) {
  var ctxStore = document.getElementById(`Store${i.toString().padStart(2, '0')}PieChart`);
  createPieChart(ctxStore, pieLabels, generateRandomData(pieLabels.length, 1, 15), backgroundColors);
}