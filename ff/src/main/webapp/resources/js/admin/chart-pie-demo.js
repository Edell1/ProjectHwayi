// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

// Pie Chart Example
var ctx = document.getElementById("furniturePieChart");
var myPieChart = new Chart(ctx, {
  type: 'pie',
  data: {
    labels: ["침대", "소파", "파티션", "거울", "서랍장", "선반", "행거/옷장", "거실장/TV장", "책장", "의자", "책상"],
    datasets: [{
      data: [9.21, 13.58, 11.25, 8.32, 1.54, 5.61, 4.38, 6.66, 4.12, 10.00, 13.00 ],
      backgroundColor: ['#007bff', '#dc3545', '#ffc107', '#28a745', '#18a745', '#28b745', '#287045', '#28a710', '#2ba745', '#28c745', '#00f745'],
    }],
  },
});
