import React from "react";
import { PieChart } from "react-minimal-pie-chart";

const PieGraph = ({data}) => {

  data = data.map((item) => ({
    ...item,
    color: getRandomColor()
  }))

  function getRandomColor() {
    return "#" + Math.floor(Math.random()*16777215).toString(16);
  }
  return (
    <div className="flex justify-center items-center w-72">
      <PieChart
        data={data.map((item) => ({
          title: item.firstName,
          value: item.participation,
          color: item.color,
        }))}

        radius={35}
        lineWidth={45}
        paddingAngle={0}
        segmentsStyle={{ transition: "stroke .3s", cursor: "pointer" }}
        segmentsShift={(index) => (index === 0 ? 1 : 0)}
        animate
        startAngle={-90}
        lengthAngle={360}
        viewBoxSize={[100, 100]}
      />
      <div className="ml-2">
        {data.map((item) => (
          <div key={item.firstName} className="flex items-center">
            <div className="w-3 h-3 mr-1" style={{ backgroundColor: item.color }}></div>
            <span className={`text-[${item.color}]`}>{item.firstName}</span>
          </div>
        ))}
      </div>
    </div>
  );
};

export default PieGraph;
