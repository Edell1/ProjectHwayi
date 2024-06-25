// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

// Function to generate random data
function generateRandomData(length, min, max) {
	return Array.from({ length: length }, () => (Math.random() * (max - min) + min).toFixed(2));
}

// Labels and color for pie charts
var pieLabels = ["침대", "소파", "파티션", "거울", "서랍장", "선반", "행거/옷장", "거실장/TV장", "책장", "의자", "책상"];
var backgroundColors = [
	'#4E79A7', // 적당히 어두운 파란색
	'#A0CBE8', // 연한 파란색
	'#FFC372', // 주황색
	'#FF7F50', // 적당히 어두운 주황색
	'#8CD790', // 연한 녹색
	'#E0A890', // 적당히 어두운 분홍색
	'#E38690', // 적당히 어두운 분홍색
	'#C0E8D5', // 연한 녹색
	'#F1E4FF', // 연한 보라색
	'#FFC0CB', // 연한 분홍색
	'#D8D8D8'   // 연한 회색
];

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