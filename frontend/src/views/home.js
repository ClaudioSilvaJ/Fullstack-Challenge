import React, {useEffect, useState} from 'react';
import Header from "../components/Header/Header";
import Table from "../components/Table/Table";
import PieGraph from "../components/PieGraph/PieGraph";
import axios from "axios";

function Home() {
  const [data, setData] = useState(null);

  async function fetchData() {
    await axios.get('http://localhost:8231/api/get'
    ).then(r => {
      setData(r.data);
    });
  }
  useEffect(() => {
    fetchData();
  }, []);
  if(data === null) {
    return <div className="flex justify-center items-center h-screen text-5xl">Loading...</div>
  }
  return (
    <div className="flex-column text-center h-screen font-oswald">
      <Header></Header>
      <div className="flex-column justify-center pt-8">
        <label className="text-4xl font-semibold">DATA</label>
        <label className="pt-4">Qualquer coisa</label>
      </div>
      <div className="flex flex-row self-center">
        <Table data={data}></Table>
        <PieGraph data={data}></PieGraph>
      </div>
    </div>
  );
}

export default Home;
