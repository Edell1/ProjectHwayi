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

var ctx01 = document.getElementById("store01BarChart");
var myLineChart = new Chart(ctx01, {
  type: 'bar',
  data: {
    labels: ["6월", "7월", "8월", "9월", "10월", "11월", "12월", "1월", "2월", "3월", "4월", "5월"],
    datasets: [{
      label: "월별 판매금액",
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
          maxTicksLimit: 12
        }
      }],
      yAxes: [{
        ticks: {
          min: 0,
          max: 100000000,
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

var ctx02 = document.getElementById("store02BarChart");
var myLineChart = new Chart(ctx02, {
  type: 'bar',
  data: {
    labels: ["6월", "7월", "8월", "9월", "10월", "11월", "12월", "1월", "2월", "3월", "4월", "5월"],
    datasets: [{
      label: "월별 판매금액",
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
          maxTicksLimit: 12
        }
      }],
      yAxes: [{
        ticks: {
          min: 0,
          max: 100000000,
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

var ctx03 = document.getElementById("store03BarChart");
var myLineChart = new Chart(ctx03, {
  type: 'bar',
  data: {
    labels: ["6월", "7월", "8월", "9월", "10월", "11월", "12월", "1월", "2월", "3월", "4월", "5월"],
    datasets: [{
      label: "월별 판매금액",
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
          maxTicksLimit: 12
        }
      }],
      yAxes: [{
        ticks: {
          min: 0,
          max: 100000000,
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

var ctx04 = document.getElementById("store04BarChart");
var myLineChart = new Chart(ctx04, {
  type: 'bar',
  data: {
    labels: ["6월", "7월", "8월", "9월", "10월", "11월", "12월", "1월", "2월", "3월", "4월", "5월"],
    datasets: [{
      label: "월별 판매금액",
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
          maxTicksLimit: 12
        }
      }],
      yAxes: [{
        ticks: {
          min: 0,
          max: 100000000,
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

var ctx05 = document.getElementById("store05BarChart");
var myLineChart = new Chart(ctx05, {
  type: 'bar',
  data: {
    labels: ["6월", "7월", "8월", "9월", "10월", "11월", "12월", "1월", "2월", "3월", "4월", "5월"],
    datasets: [{
      label: "월별 판매금액",
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
          maxTicksLimit: 12
        }
      }],
      yAxes: [{
        ticks: {
          min: 0,
          max: 100000000,
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

var ctx06 = document.getElementById("store06BarChart");
var myLineChart = new Chart(ctx06, {
  type: 'bar',
  data: {
    labels: ["6월", "7월", "8월", "9월", "10월", "11월", "12월", "1월", "2월", "3월", "4월", "5월"],
    datasets: [{
      label: "월별 판매금액",
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
          maxTicksLimit: 12
        }
      }],
      yAxes: [{
        ticks: {
          min: 0,
          max: 100000000,
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

var ctx07 = document.getElementById("store07BarChart");
var myLineChart = new Chart(ctx07, {
  type: 'bar',
  data: {
    labels: ["6월", "7월", "8월", "9월", "10월", "11월", "12월", "1월", "2월", "3월", "4월", "5월"],
    datasets: [{
      label: "월별 판매금액",
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
          maxTicksLimit: 12
        }
      }],
      yAxes: [{
        ticks: {
          min: 0,
          max: 100000000,
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

var ctx08 = document.getElementById("store08BarChart");
var myLineChart = new Chart(ctx08, {
  type: 'bar',
  data: {
    labels: ["6월", "7월", "8월", "9월", "10월", "11월", "12월", "1월", "2월", "3월", "4월", "5월"],
    datasets: [{
      label: "월별 판매금액",
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
          maxTicksLimit: 12
        }
      }],
      yAxes: [{
        ticks: {
          min: 0,
          max: 100000000,
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

var ctx09 = document.getElementById("store09BarChart");
var myLineChart = new Chart(ctx09, {
  type: 'bar',
  data: {
    labels: ["6월", "7월", "8월", "9월", "10월", "11월", "12월", "1월", "2월", "3월", "4월", "5월"],
    datasets: [{
      label: "월별 판매금액",
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
          maxTicksLimit: 12
        }
      }],
      yAxes: [{
        ticks: {
          min: 0,
          max: 100000000,
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

var ctx10 = document.getElementById("store10BarChart");
var myLineChart = new Chart(ctx10, {
  type: 'bar',
  data: {
    labels: ["6월", "7월", "8월", "9월", "10월", "11월", "12월", "1월", "2월", "3월", "4월", "5월"],
    datasets: [{
      label: "월별 판매금액",
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
          maxTicksLimit: 12
        }
      }],
      yAxes: [{
        ticks: {
          min: 0,
          max: 100000000,
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

